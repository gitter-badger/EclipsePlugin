/*******************************************************************************
 * Copyright (c) 2011 HPCC Systems.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     HPCC Systems - initial API and implementation
 ******************************************************************************/
package org.hpccsystems.eclide.wizards;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardResourceImportPage;
import org.hpccsystems.internal.Eclipse;
import org.hpccsystems.ws.WsAttributes.EspSoapFault;
import org.hpccsystems.ws.WsAttributes.WsAttributesStub;
import org.hpccsystems.ws.WsAttributes.WsAttributesStub.ECLAttribute;
import org.hpccsystems.ws.WsAttributes.WsAttributesStub.ECLModule;
import org.hpccsystems.ws.WsAttributes.WsAttributesStub.GetAttribute;
import org.hpccsystems.ws.WsAttributes.WsAttributesStub.GetAttributeResponse;
import org.hpccsystems.ws.WsAttributes.WsAttributesStub.GetAttributes;
import org.hpccsystems.ws.WsAttributes.WsAttributesStub.GetAttributesResponse;
import org.hpccsystems.ws.WsAttributes.WsAttributesStub.GetModules;
import org.hpccsystems.ws.WsAttributes.WsAttributesStub.GetModulesResponse;

public class ImportWizardPage extends WizardResourceImportPage {

	public class PasswordFieldEditor extends StringFieldEditor { 

		public PasswordFieldEditor(String name, String label, Composite parent) { 
			super(name, label, parent); 
		} 

		@Override
		protected void doFillIntoGrid(Composite parent, int numColumns) 
		{ 
			// Creates the text control 
			super.doFillIntoGrid(parent, numColumns); 

			// Now we can set the echo character 
			getTextControl().setEchoChar('*'); 
		} 
	} 


	protected StringFieldEditor fIPText;
	protected StringFieldEditor fUserText;
	protected PasswordFieldEditor fPasswordText;

	public ImportWizardPage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
		setTitle(pageName); //NON-NLS-1
		setDescription("Import an entire Repository from a remote legacy server into the workspace."); //NON-NLS-1
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#createAdvancedControls(org.eclipse.swt.widgets.Composite)
	 */	
	protected void createAdvancedControls(Composite parent) {
	}

	@Override
	protected void createSourceGroup(Composite parent) {
		Composite fileSelectionArea = new Composite(parent, SWT.NONE);
		GridData fileSelectionData = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		fileSelectionArea.setLayoutData(fileSelectionData);

		GridLayout fileSelectionLayout = new GridLayout();
		fileSelectionLayout.numColumns = 3;
		fileSelectionLayout.makeColumnsEqualWidth = false;
		fileSelectionLayout.marginWidth = 0;
		fileSelectionLayout.marginHeight = 0;
		fileSelectionArea.setLayout(fileSelectionLayout);

		fIPText = new StringFieldEditor("IPSelect", "Server IP:  ", fileSelectionArea);
		fIPText.setStringValue("10.173.84.202");
		fUserText = new StringFieldEditor("User", "User:  ", fileSelectionArea);
		fUserText.setStringValue("");
		fPasswordText = new PasswordFieldEditor("Password", "Password:  ", fileSelectionArea);
		fPasswordText.setStringValue("");
	}

	@Override
	protected ITreeContentProvider getFileProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ITreeContentProvider getFolderProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	boolean doImport() {
		final IFolder targetFolder = Eclipse.getWorkspaceRoot().getFolder(getContainerFullPath());

		try {
			final WsAttributesStub stub = new WsAttributesStub(new URL("http", fIPText.getStringValue(), 8145, "/WsAttributes").toString());
			
			ServiceClient serviceClient = stub._getServiceClient();
			Options options = serviceClient.getOptions();
			options.setUserName(fUserText.getStringValue());
			options.setPassword(fPasswordText.getStringValue());
			options.setTimeOutInMilliSeconds(180 * 1000);
//			stub.setMaintainSession(true);
			serviceClient.setOptions(options);		
			
			GetModules request = new GetModules();
			final GetModulesResponse response = stub.getModules(request);
			if (response.getOutModules() != null) {

				Job job = new Job("Importing Attributes") {
					@Override
					protected IStatus run(IProgressMonitor monitor) {
						monitor.beginTask("Importing", response.getOutModules().getECLModule().length);
						for (final ECLModule module : response.getOutModules().getECLModule()) {
							if (module.getName().equalsIgnoreCase("Trash")) {
								continue;
							}
							monitor.subTask(module.getName());

							GetAttributes request2 = new GetAttributes();
							request2.setModuleName(module.getName());
							try {
								GetAttributesResponse response2 = stub.getAttributes(request2);
								if (response2.getOutAttributes() != null) {
									int MAX_THREAD = 5;
									ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREAD);
									for (final ECLAttribute attribute : response2.getOutAttributes().getECLAttribute()) {
										String modPath = attribute.getModuleName();
										modPath.replaceAll(".", "/");
										String attrPath = attribute.getName() + ".ecl";
										IPath targetPath = targetFolder.getLocation();
										IPath fullPath = targetPath.append(modPath + "/" + attrPath).makeAbsolute();
										final File targetFile = new File(fullPath.toOSString());

										try {
											targetFile.getParentFile().mkdirs(); 
											if (targetFile.createNewFile()) {
												threadPool.execute(new Runnable() {
													@Override
													public void run() {
														GetAttribute request3 = new GetAttribute();
														request3.setModuleName(module.getName());
														request3.setAttributeName(attribute.getName());
														request3.setGetText(true);
														try {
															GetAttributeResponse response3 = stub.getAttribute(request3);
															if (response3.getOutAttribute() != null) {
																ECLAttribute attribute2 = response3.getOutAttribute();
																try {
																	FileWriter fstream = new FileWriter(targetFile);
																	BufferedWriter out = new BufferedWriter(fstream);
																	out.write(attribute2.getText());
																	out.flush();
																} catch (IOException e) {
																	// TODO Auto-generated catch block
																	e.printStackTrace();
																}
																System.out.println(attribute2.getModuleName() + "." + attribute2.getName());
															}
														} catch (RemoteException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														} catch (EspSoapFault e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
													}
												});
											}
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									threadPool.shutdown();
									try {
										while(!threadPool.awaitTermination(300, TimeUnit.MILLISECONDS)) {
											if (monitor.isCanceled()) {
												threadPool.shutdownNow();											
												return Status.CANCEL_STATUS;
											}
										}
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									if (monitor.isCanceled()) {
										return Status.CANCEL_STATUS;
									}
								}
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (EspSoapFault e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							monitor.worked(1);
						}
						return Status.OK_STATUS;
					}
				};
				job.schedule();
				return true;	
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EspSoapFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;	
	}
}
