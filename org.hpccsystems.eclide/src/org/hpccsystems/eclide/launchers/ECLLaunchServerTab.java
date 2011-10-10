package org.hpccsystems.eclide.launchers;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.internal.ui.SWTFactory;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressAdapter;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.progress.WorkbenchJob;
import org.hpccsystems.eclide.Activator;

public class ECLLaunchServerTab extends AbstractLaunchConfigurationTab {

	private class WidgetListener extends SelectionAdapter implements ModifyListener {
		public void modifyText(ModifyEvent e) {
			Object source= e.getSource();
			if (source == fIPText) {
				refreshAddress();
			} if (source == fAddressText) {
				refreshBrowser();
			}
			scheduleUpdateJob();
		}
		public void widgetSelected(SelectionEvent e) {
			Object source= e.getSource();
//			if (source == fProjButton) {
//				handleProjectButtonSelected();
//			}
//			if (source == fWorkspaceButton) {
////				handleWorkspaceDirBrowseButtonSelected();
//			}
//			else if (source == fFileSystemButton) {
////				handleWorkingDirBrowseButtonSelected();
//			} 
//			else if (source == fVariablesButton) {
////				handleWorkingDirVariablesButtonSelected();
//			} 
//			else if(source == localButton) {
//				//only perform the action if this is the button that was selected
////				if(fUseDefaultDirButton.getSelection()) {
////					setDefaultWorkingDir();
////				}
//			} 
//			else if(source == remoteButton) {
//				//only perform the action if this is the button that was selected
////				if(fUseOtherDirButton.getSelection()) {
////					handleUseOtherWorkingDirButtonSelected();
////				}
//			}
		}
	}
	
	private WidgetListener fListener = new WidgetListener();
	
    Image image;

//    // Local directory
//	private Button fWorkspaceButton;
//	private Button fFileSystemButton;
//	private Button fVariablesButton;
//	
//	//bug 29565 fix
//	private Button localButton = null;
//	private Button remoteButton = null;
	protected Text fIPText;
	protected Text fAddressText;
	protected Text fClusterText;
	private Browser browser;

	protected void createServerEditor(Composite parent) {
		Group group = SWTFactory.createGroup(parent, "Server:", 2, 1, GridData.FILL_HORIZONTAL);
		SWTFactory.createLabel(group, "IP Address:  ", 1);
		fIPText = SWTFactory.createSingleText(group, 1);
		fIPText.addModifyListener(fListener);

		SWTFactory.createLabel(group, "Cluster:  ", 1);
		fClusterText = SWTFactory.createSingleText(group, 1);
		fClusterText.addModifyListener(fListener);
	}
	
	public class Ch12WebBrowserComposite extends Composite {
		private Browser browser;

		public Ch12WebBrowserComposite(Composite parent) {
			super(parent, SWT.BORDER);

			GridLayout layout = new GridLayout(2, true);
			setLayout(layout);

			browser = new Browser(this, SWT.NONE);
			GridData layoutData = new GridData(GridData.FILL_BOTH);
			layoutData.horizontalSpan = 2;
			layoutData.verticalSpan = 2;
			browser.setLayoutData(layoutData);
			browser.setUrl("http://www.slashdot.org");

			final Text text = new Text(this, SWT.SINGLE);
			layoutData = new GridData(GridData.FILL_HORIZONTAL);
			text.setLayoutData(layoutData);

			Button openButton = new Button(this, SWT.PUSH);
			openButton.setText("Open");
			openButton.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {
					browser.setUrl(text.getText());
				}

				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});

			Button backButton = new Button(this, SWT.PUSH);
			backButton.setText("Back");
			backButton.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {
					browser.back();
				}

				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});

			Button forwardButton = new Button(this, SWT.PUSH);
			forwardButton.setText("Forward");
			forwardButton.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {
					browser.forward();
				}

				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
		}
	}

	protected void createBrowser(Composite parent) {
		Group group = SWTFactory.createGroup(parent, "ECL Watch:", 2, 1, GridData.FILL_BOTH);
		SWTFactory.createLabel(group, "Address:  ", 1);
		fAddressText = SWTFactory.createSingleText(group, 1);
		fAddressText.addModifyListener(fListener);

		browser = new Browser(group, SWT.BORDER);
		browser.setUrl("about:blank");
    	GridData gd = new GridData(GridData.FILL_BOTH);
    	gd.horizontalSpan = 2;
    	browser.setLayoutData(gd);
	}

	public final void createControl(Composite parent) {
		Composite projComp = SWTFactory.createComposite(parent, parent.getFont(), 1, 1, GridData.FILL_BOTH); 
		((GridLayout)projComp.getLayout()).verticalSpacing = 0;
		
		createVerticalSpacer(projComp, 1);
		createServerEditor(projComp);
		createVerticalSpacer(projComp, 1);
		createBrowser(projComp);
		setControl(projComp);
		
//		Font font = parent.getFont();	
//		SWTFactory.createHorizontalSpacer(parent, 1);
//
//		Group serverGroup = SWTFactory.createGroup(parent, "Server", 2, 1, GridData.FILL_HORIZONTAL);
//		setControl(serverGroup);
//		SWTFactory.createLabel(serverGroup, "IP Address:  ", 1);
//		ip = SWTFactory.createSingleText(serverGroup, 1); 
//		ip.addModifyListener(fListener);
//
//		SWTFactory.createLabel(serverGroup, "Cluster:  ", 1);
//		cluster = SWTFactory.createSingleText(serverGroup, 1);
//		cluster.addModifyListener(fListener);
//
//		//setControl(parent);
//		//Group launchItemGroup = SWTFactory.createGroup(parent, "Launch Item", 2, 1, GridData.FILL_HORIZONTAL);
//		setControl(serverGroup);
//		fProjText = SWTFactory.createSingleText(serverGroup, 1);
//		fProjText.addModifyListener(fListener);
//		//ControlAccessibleListener.addListener(fProjText, group.getText());
//		fProjButton = createPushButton(serverGroup, "LauncherMessages.AbstractJavaMainTab_1", null); 
//		fProjButton.addSelectionListener(fListener);
//
//		Composite projComp = SWTFactory.createComposite(parent, parent.getFont(), 1, 1, GridData.FILL_BOTH); 
//		((GridLayout)projComp.getLayout()).verticalSpacing = 0;
//
//		Group group = SWTFactory.createGroup(parent, "LauncherMessages.AbstractJavaMainTab_0", 2, 1, GridData.FILL_HORIZONTAL);
//		fProjText = SWTFactory.createSingleText(group, 1);
//		fProjText.addModifyListener(fListener);
//		//ControlAccessibleListener.addListener(fProjText, group.getText());
//		fProjButton = createPushButton(group, "LauncherMessages.AbstractJavaMainTab_1", null); 
//		fProjButton.addSelectionListener(fListener);
//		
//		createVerticalSpacer(projComp, 1);
//		createMainTypeEditor(projComp, LauncherMessages.appletlauncher_maintab_mainclasslabel_name);
//		createVerticalSpacer(projComp, 1);
//		createAppletViewerControl(projComp);
//		setControl(projComp);
	//	PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), IJavaDebugHelpContextIds.LAUNCH_CONFIGURATION_DIALOG_APPLET_MAIN_TAB);
	
		
//		//buttons
//		Composite buttonComp = SWTFactory.createComposite(comp, font, 3, 2, GridData.HORIZONTAL_ALIGN_END); 
//		GridLayout ld = (GridLayout)buttonComp.getLayout();
//		ld.marginHeight = 1;
//		ld.marginWidth = 0;
//		fWorkspaceButton = createPushButton(buttonComp, DebugUIMessages.WorkingDirectoryBlock_0, null); 
//		fWorkspaceButton.addSelectionListener(fListener);
//		fFileSystemButton = createPushButton(buttonComp, DebugUIMessages.WorkingDirectoryBlock_1, null); 
//		fFileSystemButton.addSelectionListener(fListener);
//		fVariablesButton = createPushButton(buttonComp, DebugUIMessages.WorkingDirectoryBlock_17, null); 
//		fVariablesButton.addSelectionListener(fListener);
	}
	
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
//		ip.setText("localhost");
//		cluster.setText("hthor");
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			fIPText.setText(configuration.getAttribute(ECLLaunchConstants.P_IP, "localhost"));
			fClusterText.setText(configuration.getAttribute(ECLLaunchConstants.P_CLUSTER, "hthor"));
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ECLLaunchConstants.P_IP, fIPText.getText());
		configuration.setAttribute(ECLLaunchConstants.P_CLUSTER, fClusterText.getText());
	}

	protected void handleProjectButtonSelected() {
//		IJavaProject project = chooseJavaProject();
//		if (project == null) {
//			return;
//		}
//		String projectName = project.getElementName();
//		fProjText.setText(projectName);		
	}

	void refreshAddress() {
		StringBuilder url = new StringBuilder("http://");
		url.append(fIPText.getText());
		url.append(":8010/");
		fAddressText.setText(url.toString());
	}
	
	void refreshBrowser() {
		browser.addProgressListener(new ProgressAdapter() {
			public void completed(ProgressEvent event) {
				browser.removeProgressListener(this);
				System.out.println(fAddressText.getText());
				browser.setUrl(fAddressText.getText());
			}
		});
		browser.setText("<html><body><h3>Loading (" + fAddressText.getText() + ")...</h3></body></html>");
	}

	@Override
	public String getName() {
		return "HPCC Platform";
	}

    public Image getImage() {
        if (image == null) {
        	image = Activator.getImage("icons/releng_gears.gif"); //$NON-NLS-1$
        }
        return image;
    }
    
    //  3.7 backported  ---
	private Job fRereshJob;	

	private Job getUpdateJob() {
		if (fRereshJob == null) {
			fRereshJob = createUpdateJob();
			fRereshJob.setSystem(true);
		}
		return fRereshJob;
	}
	
	protected void scheduleUpdateJob() {
		Job job = getUpdateJob();
		job.cancel(); // cancel existing job
		job.schedule(getUpdateJobDelay());
	}
	
	protected Job createUpdateJob() {
		return  new WorkbenchJob(getControl().getDisplay(), "Update LCD") { //$NON-NLS-1$
			public IStatus runInUIThread(IProgressMonitor monitor) {
				if (!getControl().isDisposed()) {
					updateLaunchConfigurationDialog();
				}
				return Status.OK_STATUS;
			}
			public boolean shouldRun() {
				return !getControl().isDisposed();
			}
		};
	}
	
	protected long getUpdateJobDelay() {
		return 200;
	}	
}
