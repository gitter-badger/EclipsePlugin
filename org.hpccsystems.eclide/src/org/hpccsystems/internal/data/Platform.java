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
package org.hpccsystems.internal.data;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashSet;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import org.hpccsystems.eclide.Activator;
import org.hpccsystems.eclide.builder.ECLCompiler;
import org.hpccsystems.internal.ConfigurationPreferenceStore;
import org.hpccsystems.ws.wstopology.WsTopologyStub;
import org.hpccsystems.ws.wstopology.WsTopologyStub.ArrayOfTpDropZone;
import org.hpccsystems.ws.wstopology.WsTopologyStub.ArrayOfTpLogicalCluster;
import org.hpccsystems.ws.wstopology.WsTopologyStub.TpDropZone;
import org.hpccsystems.ws.wstopology.WsTopologyStub.TpLogicalCluster;
import org.hpccsystems.ws.wstopology.WsTopologyStub.TpLogicalClusterQueryRequest;
import org.hpccsystems.ws.wstopology.WsTopologyStub.TpLogicalClusterQueryResponse;
import org.hpccsystems.ws.wstopology.WsTopologyStub.TpServiceQueryRequest;
import org.hpccsystems.ws.wstopology.WsTopologyStub.TpServiceQueryResponse;
import org.hpccsystems.ws.wstopology.WsTopologyStub.TpServices;
import org.hpccsystems.ws.wstopology.WsTopologyStub.TpTargetCluster;
import org.hpccsystems.ws.filespray.FileSprayStub;
import org.hpccsystems.ws.filespray.FileSprayStub.ArrayOfDFUWorkunit;
import org.hpccsystems.ws.filespray.FileSprayStub.DFUWorkunit;
import org.hpccsystems.ws.filespray.FileSprayStub.GetDFUWorkunits;
import org.hpccsystems.ws.filespray.FileSprayStub.GetDFUWorkunitsResponse;
import org.hpccsystems.ws.wsdfu.WsDfuStub;
import org.hpccsystems.ws.wsdfu.WsDfuStub.ArrayOfDFULogicalFile;
import org.hpccsystems.ws.wsdfu.WsDfuStub.DFULogicalFile;
import org.hpccsystems.ws.wsdfu.WsDfuStub.DFUQueryRequest;
import org.hpccsystems.ws.wsdfu.WsDfuStub.DFUQueryResponse;
import org.hpccsystems.ws.wsworkunits.EspSoapFault;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ApplicationValue;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ArrayOfApplicationValue;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ArrayOfECLWorkunit;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ArrayOfQuerySet;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ECLSourceFile;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ECLWorkunit;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.QuerySet;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUCreateAndUpdate;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUQuery;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUQueryResponse;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUQuerysets;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUQuerysetsResponse;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUSubmit;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUUpdateResponse;

public class Platform extends DataSingleton {
	public static DataSingletonCollection All = new DataSingletonCollection();	
	public static Platform get(String ip, int port) {
		if (ip == null || ip.isEmpty()) {
			return null;
		}

		return (Platform)All.get(new Platform(ip, port));
	}
	public static Platform getNoCreate(String ip, int port) {
		if (ip == null || ip.isEmpty()) {
			return null;
		}

		return (Platform)All.getNoCreate(new Platform(ip, port));
	}

	public static final String P_DISABLED = "disabledConfig";
	public static final String P_IP = "ipLaunchConfig";
	public static final String P_PORT = "portLaunchConfig";
	public static final String P_USER = "userLaunchConfig";
	public static final String P_PASSWORD = "passwordLaunchConfig";
	public static final String P_CLUSTER = "clusterLaunchConfig";

	private ConfigurationPreferenceStore launchConfiguration;	
	private String name;
	private boolean isDisabled;
	private String ip;
	private int port;
	private Collection<Cluster> clusters;
	private Collection<DropZone> dropZones;
	private Collection<Workunit> workunits;	
	private Collection<FileSprayWorkunit> fileSprayWorkunits;
	private Collection<DataQuerySet> dataQuerySets;
	private Collection<LogicalFile> logicalFiles;

	static int LATENCY_TEST = 0;

	Platform(String ip, int port) {
		this.ip = ip;
		this.port = port;
		isDisabled = true;
		name = "";

		clusters = new HashSet<Cluster>();
		dropZones = new HashSet<DropZone>();
		workunits = new HashSet<Workunit>();	
		fileSprayWorkunits = new HashSet<FileSprayWorkunit>();
		dataQuerySets = new HashSet<DataQuerySet>();
		logicalFiles = new HashSet<LogicalFile>();
	}

	public void update(ILaunchConfiguration _launchConfiguration) {
		launchConfiguration = new ConfigurationPreferenceStore(_launchConfiguration);
		name = _launchConfiguration.getName();
		isDisabled = launchConfiguration.getAttribute(P_DISABLED, true);
		ip = launchConfiguration.getAttribute(P_IP, "");
		port = launchConfiguration.getAttribute(P_PORT, 8010);
	}

	synchronized void confirmDisable() {
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				if (!isDisabled) {
					Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
					if (MessageDialog.openConfirm(activeShell, "ECL Plug-in", "\"" + name + "\" is Unreachable.  Disable for current session?\n(Can be permanently disabled in the Launch Configuration)")) {
						isDisabled = true;
					}
				}
			}
		});
	}

	public boolean isDisabled() {
		return isDisabled;
	}

	public boolean isEnabled() {
		return !isDisabled;
	}

	public String getIP() {
		return ip;
	}

	public int getPort() {
		return port;
	}

	public String getUser() {
		return launchConfiguration.getAttribute(P_USER, "");
	}

	public String getPassword() {
		return launchConfiguration.getAttribute(P_PASSWORD, "");
	}

	/*
 enum WUAction
{
    WUActionUnknown = 0,
    WUActionCompile = 1,
    WUActionCheck = 2,
    WUActionRun = 3,
    WUActionExecuteExisting = 4,
    WUActionPause = 5, 
    WUActionPauseNow = 6, 
    WUActionResume = 7, 
    WUActionSize = 8
};
	 */	
	Collection<Workunit> getWorkunits(String cluster, String startDate, String endDate) {
		if (isEnabled()) {
			Workunit.All.pushTransaction("platform.getWorkunits");
			
			WsWorkunitsStub stub = getWsWorkunitsService();
			WUQuery request = new WUQuery();
			request.setCluster(cluster);
			request.setStartDate(startDate);
			request.setEndDate(startDate);
			request.setCount(100);
			try {
				WUQueryResponse response = stub.wUQuery(request);
				updateWorkunits(response.getWorkunits());
			} catch (EspSoapFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				confirmDisable();
				e.printStackTrace();
			}
			Workunit.All.popTransaction();
		}
		return new HashSet<Workunit>(workunits);
	}

	public Workunit submit(ILaunchConfiguration configuration, IFile file, String cluster) {
		if (isEnabled()) {
			ECLCompiler compiler = new ECLCompiler(new ConfigurationPreferenceStore(configuration), file.getProject());
			String archive = compiler.getArchive(file);
			if (!archive.isEmpty())
			{
				try {
					Workunit.All.pushTransaction("Platform.submit");
					WsWorkunitsStub stub = getWsWorkunitsService();;
					WUCreateAndUpdate request = new WUCreateAndUpdate();
					request.setQueryText(archive);
					request.setJobname(file.getFullPath().removeFileExtension().lastSegment());
					ArrayOfApplicationValue appVals = new ArrayOfApplicationValue();
					ApplicationValue appVal = new ApplicationValue();
					appVal.setApplication(Activator.PLUGIN_ID);
					appVal.setName("path");
					appVal.setValue(file.getFullPath().toPortableString());
					appVals.addApplicationValue(appVal);
					request.setApplicationValues(appVals);

					int inlineResultLimit = launchConfiguration.getInt(ClientTools.P_INLINERESULTLIMIT);
					if (inlineResultLimit > 0) {
						request.setResultLimit(inlineResultLimit);
					}

					try {
						WUUpdateResponse response = stub.wUCreateAndUpdate(request);
						response.getWorkunit().setCluster(cluster);	//  WUSubmit does not return an updated ECLWorkunit, so set cluster here...  
						Workunit wu = getWorkunit(response.getWorkunit());
						if (wu != null) {
							workunits.add(wu);

							WUSubmit submitRequest = new WUSubmit();
							submitRequest.setWuid(response.getWorkunit().getWuid());
							submitRequest.setCluster(cluster);
							stub.wUSubmit(submitRequest);
						}
						return wu;
					} catch (EspSoapFault e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} finally {
					Workunit.All.popTransaction();
				}
			}
		}
		return null;
	}

	@Override
	boolean isComplete() {
		return true;
	}

	@Override
	void fastRefresh() {
	}

	@Override
	void fullRefresh() {
	}

	//  Workunit  ---
	public Workunit getWorkunit(String wuid) {
		return Workunit.get(this, wuid);
	}

	public Workunit getWorkunit(ECLWorkunit wu) {
		Workunit workunit = getWorkunit(wu.getWuid());
		workunit.update(wu);
		return workunit;
	}

	public Collection<Workunit> getWorkunits(String cluster) {
		return getWorkunits(cluster, "", "");
	}

	public Collection<Workunit> getWorkunits() {
		return getWorkunits("", "", "");
	}
	
	boolean isValid(String wuid) {
		//W20120816-100734
		if (wuid.length() >= 16) {
			if (wuid.startsWith("W")) {
				for (int i = 1; i < 8; ++i) {
					if (!Character.isDigit(wuid.charAt(i)))
						return false;
				}
				return true;
			}
		}
		
		return false;
	}

	synchronized void updateWorkunits(ArrayOfECLWorkunit rawWorkunits) {
		workunits.clear();
		if (rawWorkunits != null) {
			for(ECLWorkunit wu : rawWorkunits.getECLWorkunit()) {
				if (isValid(wu.getWuid())) {
					workunits.add(getWorkunit(wu)); 	//  Will mark changed if needed  ---
				}
			}
		}
	}

	//  FileSPrayWorkunit  ---
	public FileSprayWorkunit getFileSprayWorkunit(String id) {
		return FileSprayWorkunit.get(this, id);
	}

	public FileSprayWorkunit getFileSprayWorkunit(DFUWorkunit wu) {
		FileSprayWorkunit workunit = getFileSprayWorkunit(wu.getID());
		workunit.update(wu);
		return workunit;
	}

	public FileSprayWorkunit[] getFileSprayWorkunits(String cluster){
		if (isEnabled()) {
			//TODO CollectionDelta monitor = new CollectionDelta("getFileSprayWorkunits", fileSprayWorkunits);
			FileSprayStub stub = getFileSprayService();
			GetDFUWorkunits request = new GetDFUWorkunits();
			request.setPageSize(new Long(100));
			request.setCluster(cluster);
			try {
				GetDFUWorkunitsResponse response = stub.getDFUWorkunits(request);
				updateFileSprayWorkunits(response.getResults());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (org.hpccsystems.ws.filespray.EspSoapFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//TODO notifyObservers(monitor.calcChanges(fileSprayWorkunits));
 		}
		return fileSprayWorkunits.toArray(new FileSprayWorkunit[0]);
	}

	public FileSprayWorkunit[] getFileSprayWorkunits() {
		return getFileSprayWorkunits("");
	}

	synchronized void updateFileSprayWorkunits(ArrayOfDFUWorkunit rawWorkunits) {
		fileSprayWorkunits.clear();
		if (rawWorkunits != null) {
			for(DFUWorkunit wu : rawWorkunits.getDFUWorkunit()) {
				fileSprayWorkunits.add(getFileSprayWorkunit(wu)); 	//  Will mark changed if needed  ---
			}
		}
	}

	//  LogicalFile  ---
	public DataQuerySet getDataQuerySet(String name) {
		return DataQuerySet.get(this, name);
	}

	public DataQuerySet getDataQuerySet(QuerySet qs) {
		DataQuerySet dataQuerySet = getDataQuerySet(qs.getQuerySetName());
		dataQuerySet.Update(qs);
		return dataQuerySet;
	}

	public DataQuerySet[] getDataQuerySets() {
		if (isEnabled()) {
			//TODO CollectionDelta monitor = new CollectionDelta("getDataQuerySets", dataQuerySets);
			WsWorkunitsStub stub = getWsWorkunitsService();;
			WUQuerysets request = new WUQuerysets();
			try {
				WUQuerysetsResponse response = stub.wUQuerysets(request);
				updateDataQuerySets(response.getQuerysets());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EspSoapFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//TODO notifyObservers(monitor.calcChanges(dataQuerySets));
 		}
		return dataQuerySets.toArray(new DataQuerySet[0]);
	}

	synchronized void updateDataQuerySets(ArrayOfQuerySet rawQuerySets) {
		dataQuerySets.clear();
		if (rawQuerySets != null) {
			for(QuerySet qs : rawQuerySets.getQuerySet()) {
				dataQuerySets.add(getDataQuerySet(qs)); 	//  Will mark changed if needed  ---
			}
		}
	}

	//  LogicalFile  ---
	public LogicalFile getLogicalFile(String name) {
		return LogicalFile.get(this, name);
	}

	public LogicalFile getLogicalFile(DFULogicalFile lf) {
		LogicalFile logicalFile = getLogicalFile(lf.getName());
		logicalFile.Update(lf);
		return logicalFile;
	}

	public LogicalFile getLogicalFile(ECLSourceFile sf) {
		LogicalFile logicalFile = getLogicalFile(sf.getName());
		logicalFile.Update(sf);
		return logicalFile;
	}

	public LogicalFile[] getLogicalFiles(String cluster) {
		if (isEnabled()) {
			//TODO CollectionDelta monitor = new CollectionDelta("getLogicalFiles", logicalFiles);
			WsDfuStub stub = getWsDfuService();
			DFUQueryRequest request = new DFUQueryRequest();
			request.setClusterName(cluster);
			try {
				DFUQueryResponse response = stub.dFUQuery(request);
				updateLogicalFiles(response.getDFULogicalFiles());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (org.hpccsystems.ws.wsdfu.EspSoapFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//TODO notifyObservers(monitor.calcChanges(logicalFiles));
		}
		return logicalFiles.toArray(new LogicalFile[0]);
	}

	public LogicalFile[] getLogicalFiles() {
		return getLogicalFiles("");
	}

	synchronized void updateLogicalFiles(ArrayOfDFULogicalFile rawLogicalFiles) {
		logicalFiles.clear();
		if (rawLogicalFiles != null) {
			for(DFULogicalFile lf : rawLogicalFiles.getDFULogicalFile()) {
				logicalFiles.add(getLogicalFile(lf)); 	//  Will mark changed if needed  ---
			}
		}
	}

	//  Cluster  ---
	public Cluster getCluster(String name) {
		return Cluster.get(this, name);
	}

	public Cluster getCluster(TpTargetCluster tc) {
		Cluster cluster = getCluster(tc.getName());
		cluster.Update(tc);
		return cluster;
	}

	public Cluster[] getClusters() {
		if (isEnabled()) {
			//TODO CollectionDelta monitor = new CollectionDelta("getClusters", clusters);
			WsTopologyStub stub = getWsTopologyService();
			TpLogicalClusterQueryRequest request = new TpLogicalClusterQueryRequest();
			try {
				TpLogicalClusterQueryResponse response = stub.tpLogicalClusterQuery(request);
				updateClusters(response.getTpLogicalClusters());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (org.hpccsystems.ws.wstopology.EspSoapFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//TODO notifyObservers(monitor.calcChanges(clusters));
		}
		return clusters.toArray(new Cluster[0]);
	}

	synchronized void updateClusters(ArrayOfTpLogicalCluster tpLogicalClusters) {
		if (tpLogicalClusters != null) {
			for(TpLogicalCluster c : tpLogicalClusters.getTpLogicalCluster()) {
				clusters.add(getCluster(c.getName())); 	//  Will mark changed if needed  ---
			}
		}
	}

	//  Drop Zones  ---
	public DropZone getDropZone(String name) {
		return DropZone.get(this, name);
	}

	public DropZone getDropZone(TpDropZone dz) {
		DropZone dropZone = getDropZone(dz.getName());
		dropZone.update(dz);
		return dropZone;
	}

	public DropZone[] getDropZones() {
		if (isEnabled()) {
			//TODO CollectionDelta monitor = new CollectionDelta("getClusters", clusters);
			WsTopologyStub stub = getWsTopologyService();
			TpServiceQueryRequest request = new TpServiceQueryRequest();
			request.setType("ALLSERVICES");
			try {
				TpServiceQueryResponse response = stub.tpServiceQuery(request);
				updateServices(response.getServiceList());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (org.hpccsystems.ws.wstopology.EspSoapFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//TODO notifyObservers(monitor.calcChanges(clusters));			
		}
		return dropZones.toArray(new DropZone[0]);
	}

	private void updateServices(TpServices serviceList) {
		if (serviceList != null) {
			updateDropZones(serviceList.getTpDropZones());
		}

	}
	private void updateDropZones(ArrayOfTpDropZone rawDropZones) {
		if (rawDropZones != null) {
			for(TpDropZone dz : rawDropZones.getTpDropZone()) {
				dropZones.add(getDropZone(dz));
			}
		}
	}

	//  SOAP Stub Helpers  ---
	public URL getURL() throws MalformedURLException {
		return getURL("");
	}

	public URL getURL(String service) throws MalformedURLException {
		return new URL("http", getIP(), getPort(), "/" + service);
	}

	public URL getURL(String service, int port) throws MalformedURLException {
		return new URL("http", getIP(), port, "/" + service);
	}

	public URL getURL(String service, String method) throws MalformedURLException {
		return getURL(service + "/" + method);
	}

	public URL getURL(String service, String method, String params) throws MalformedURLException {
		return getURL(service + "/" + method + "?" + params);
	}

	void initStub(org.apache.axis2.client.Stub stub) {
		final ServiceClient serviceClient = stub._getServiceClient();
		final Options options = serviceClient.getOptions();
		HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
	    basicAuth.setUsername(getUser());
	    basicAuth.setPassword(getPassword());
	    basicAuth.setPreemptiveAuthentication(true);	    
	    options.setProperty(HTTPConstants.AUTHENTICATE, basicAuth);		
	    options.setProperty(HTTPConstants.CHUNKED, false);
		options.setTimeOutInMilliSeconds(180 * 1000);
//		stub.setMaintainSession(true);
		serviceClient.setOptions(options);		

		//  Test
		/*
		MultiThreadedHttpConnectionManager multiThreadedHttpConnectionManager = new MultiThreadedHttpConnectionManager();

	    HttpConnectionManagerParams params = new HttpConnectionManagerParams();
	    params.setDefaultMaxConnectionsPerHost(20);
	    params.setMaxTotalConnections(20);
	    params.setSoTimeout(20000);
	    params.setConnectionTimeout(20000);
	    multiThreadedHttpConnectionManager.setParams(params);

	    HttpClient httpClient = new HttpClient(multiThreadedHttpConnectionManager);

	    serviceClient.getServiceContext().getConfigurationContext().setProperty(HTTPConstants.CACHED_HTTP_CLIENT, httpClient);
	    */		
	}

	void latencyTest() {
		if (LATENCY_TEST == 0) {
			return;
		}

		try {
			Thread.sleep(LATENCY_TEST);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WsWorkunitsStub getWsWorkunitsService() {
		latencyTest();
		try {
			WsWorkunitsStub stub = new WsWorkunitsStub(getURL("WsWorkunits").toString());
			initStub(stub);
			return stub;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	public WsDfuStub getWsDfuService() {
		latencyTest();
		try {
			WsDfuStub stub = new WsDfuStub(getURL("WsDfu").toString());
			initStub(stub);
			return stub;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	public FileSprayStub getFileSprayService() {
		latencyTest();
		try {
			FileSprayStub stub = new FileSprayStub(getURL("FileSpray").toString());
			initStub(stub);
			return stub;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	public WsTopologyStub getWsTopologyService() {
		latencyTest();
		try {
			String dummy = getURL("WsTopology").toString();
			WsTopologyStub service = new WsTopologyStub(getURL("WsTopology").toString());
			initStub(service);
			return service;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	@Override 
	public boolean equals(Object aThat) {
		if ( this == aThat ) {
			return true;
		}

		if ( !(aThat instanceof Platform) ) {
			return false;
		}
		Platform that = (Platform)aThat;

		//now a proper field-by-field evaluation can be made
		return 	EqualsUtil.areEqual(getIP(), that.getIP()) &&
				EqualsUtil.areEqual(getPort(), that.getPort());
	}

	@Override
	public int hashCode() {
		int result = HashCodeUtil.SEED;
		result = HashCodeUtil.hash(result, getIP());
		result = HashCodeUtil.hash(result, getPort());
		return result;
	}
}
