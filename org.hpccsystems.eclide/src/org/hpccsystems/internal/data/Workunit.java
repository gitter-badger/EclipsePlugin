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

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.hpccsystems.eclide.Activator;
import org.hpccsystems.ws.wsworkunits.EspSoapFault;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ApplicationValue;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ArrayOfApplicationValue;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ArrayOfECLGraph;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ArrayOfECLResult;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ArrayOfECLSourceFile;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ECLGraph;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ECLQuery;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ECLResult;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ECLSourceFile;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.ECLWorkunit;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.EspException;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.EspStringArray;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUAbort;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUDelete;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUInfo;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUInfoResponse;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUPublishWorkunit;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUQuery;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUQueryResponse;
import org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUResubmit;

public class Workunit extends DataSingleton {
	public static DataSingletonCollection All = new DataSingletonCollection();	
	public static Workunit get(Platform platform, String wuid) {
		if (wuid == null || wuid.isEmpty()) {
			return null;
		}

		return (Workunit)All.get(new Workunit(platform, wuid));
	}

	private Platform platform;

	private ECLWorkunit info;
	private Collection<String> resultViews; 
	private Collection<Result> results;	
	private Collection<Graph> graphs;
	private Collection<LogicalFile> sourceFiles;
	private Map<String, String> applicationValues;

	public enum Notification {
		WORKUNIT,
		CLUSTER,
		QUERY,
		APPLICATIONVALUES,
		RESULTS,
		GRAPHS,
		SOURCEFILES, 
		JOBNAME
	}

	private Workunit(Platform platform, String wuid) {
		this.platform = platform;
		info = new ECLWorkunit();
		info.setWuid(wuid); 		
		resultViews = new ArrayList<String>(); 		
		results = new ArrayList<Result>(); 		
		graphs = new ArrayList<Graph>(); 		
		sourceFiles = new ArrayList<LogicalFile>(); 		
		applicationValues = new HashMap<String, String>();
		setChanged();
	}

	public Platform getPlatform() {
		return platform;
	}

	public String getWuid() {
		return info.getWuid();
	}

	public String getQueryText() {
		if (info.getQuery() == null) {
			fullRefresh(false, false, false, false);
		}
		if (info.getQuery() != null && info.getQuery().getText() != null) {
			return info.getQuery().getText();
		}
		return "";
	}

	public Object getClusterName() {
		if (info.getCluster() == null) {
			fullRefresh(false, false, false, false);
		}
		return info.getCluster();
	}

	/*
	WUStateUnknown = 0,
	WUStateCompiled,1
	WUStateRunning,2
	WUStateCompleted,3
	WUStateFailed,4
	WUStateArchived,5
	WUStateAborting,6
	WUStateAborted,7
	WUStateBlocked,8
	WUStateSubmitted,9
	WUStateScheduled,10
	WUStateCompiling,11
	WUStateWait,12
	WUStateWaitingForUpload,13
	WUStateDebugPaused,14
	WUStateDebugRunning,15
	WUStateSize

	WUStateNoLongerOnServer 999
	 */

	public State getStateID() {
		switch (info.getStateID()) {
		case 1:
			return State.COMPILED;
		case 2:
			return State.RUNNING;
		case 3:
			return State.COMPLETED;
		case 4:
			return State.FAILED;
		case 5:
			return State.ARCHIVED;
		case 6:
			return State.ABORTING;
		case 7:
			return State.ABORTED;
		case 8:
			return State.BLOCKED;
		case 9:
			return State.SUBMITTED;
		case 10:
			return State.SCHEDULED;
		case 11:
			return State.COMPILING;
		case 12:
			return State.WAIT;
		case 13:
			return State.WAIT;
		case 14:
			return State.WAIT;
		case 15:
			return State.RUNNING;
		case 999:
			return State.UNKNOWN_ONSERVER;
		}
		return State.UNKNOWN;
	}

	public String getState() {
		if (info.getState() == null) {
			fastRefresh();
		}
		return info.getState() != null ? info.getState() : "Unknown";

	}

	public String[] getResultViews() {
		if (resultViews == null) {
			fullRefresh(false, true, false, false);
		}
		return resultViews.toArray(new String[0]);
	}

	public boolean hasApplicationValue(String key) {
		if (applicationValues.isEmpty()) {
			fullRefresh(false, false, false, true);
		}
		if (applicationValues.containsKey(key)) {
			return true;
		}
		return false;
	}

	public String getApplicationValue(String key) {
		if (applicationValues.isEmpty()) {
			fullRefresh(false, false, false, true);
		}
		if (applicationValues.containsKey(key)) {
			return applicationValues.get(key);
		}
		return "";
	}
	//  Results  ---
	public synchronized Result getResult(Integer sequence) {
		return Result.get(this, sequence);
	}

	public Result getResult(ECLResult r) {
		Result result = getResult(r.getSequence());
		result.Update(r);
		return result;
	}

	public Result[] getResults() {
		fullRefresh(false, true, false, false);
		return results.toArray(new Result[0]);
	}

	//  Graphs  ---
	synchronized Graph getGraph(String name) {
		return Graph.get(this, name);
	}

	Graph getGraph(ECLGraph g) {
		Graph graph = getGraph(g.getName());
		graph.Update(g);
		return graph;
	}

	public Graph[] getGraphs() {
		fullRefresh(true, false, false, false);
		return graphs.toArray(new Graph[0]);
	}

	//  Source Files  ---
	synchronized LogicalFile getSourceFile(String name) {
		return LogicalFile.get(platform, name);
	}

	LogicalFile getSourceFile(ECLSourceFile sf) {
		LogicalFile sourceFile = getSourceFile(sf.getName());
		sourceFile.Update(sf);
		return sourceFile;
	}

	public LogicalFile[] getSourceFiles() {
		fullRefresh(false, false, true, false);
		return sourceFiles.toArray(new LogicalFile[0]);
	}

	@Override
	public boolean isComplete() {
		return StateHelper.isCompleted(getStateID());
	}

	public String getJobname() {
		String retVal = info.getJobname();
		if (retVal == null) {
			return "";
		}
		return retVal;
	}
	//  Actions  ---
	public void abort() {
		WsWorkunitsStub stub = platform.getWsWorkunitsService();
		if (stub != null) {
			WUAbort request = new WUAbort();
			EspStringArray wuids = new EspStringArray();
			wuids.addItem(info.getWuid());
			request.setWuids(wuids);
			try {
				stub.wUAbort(request);
				refreshState();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (EspSoapFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void delete() {
		WsWorkunitsStub stub = platform.getWsWorkunitsService();
		if (stub != null) {
			WUDelete request = new WUDelete();
			EspStringArray wuids = new EspStringArray();
			wuids.addItem(info.getWuid());
			request.setWuids(wuids);
			try {
				stub.wUDelete(request);
				refreshState();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (EspSoapFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public void resubmit(boolean restart, boolean clone) {
		WsWorkunitsStub stub = platform.getWsWorkunitsService();
		if (stub != null) {
			WUResubmit request = new WUResubmit();
			request.setResetWorkflow(restart);
			request.setCloneWorkunit(clone);
			EspStringArray wuids = new EspStringArray();
			wuids.addItem(info.getWuid());
			request.setWuids(wuids);
			try {
				stub.wUResubmit(request);
				refreshState();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (EspSoapFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void resubmit() {
		resubmit(false, false);
	}

	public void restart() {
		resubmit(true, false);
	}

	public void _clone() {
		resubmit(false, true);
	}

	public void publish() {
		WsWorkunitsStub stub = platform.getWsWorkunitsService();
		if (stub != null) {
			WUPublishWorkunit request = new WUPublishWorkunit();
			request.setWuid(info.getWuid());
			try {
				stub.wUPublishWorkunit(request);
				refreshState();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (EspSoapFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//  Refresh  ---
	public void refreshState() {
		fullRefresh(false, false, false, false);
	}

	@Override
	void fastRefresh() {
		State previousState = getStateID();
		WsWorkunitsStub stub = platform.getWsWorkunitsService();
		if (stub != null) {
			WUQuery request = new WUQuery();
			request.setWuid(info.getWuid());
			request.setCount(1);
			try {
				WUQueryResponse response = stub.wUQuery(request);
				if (response.getWorkunits() != null && response.getWorkunits().getECLWorkunit().length == 1) {
					update(response.getWorkunits().getECLWorkunit()[0]);
				}		
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EspSoapFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (previousState != getStateID()) {
			fullRefresh();
		}
	}

	@Override
	void fullRefresh() {
		fullRefresh(true, true, true, true);
	}

	void fullRefresh(boolean includeGraphs, boolean includeResults, boolean includeSourceFiles, boolean includeApplicationValues) {
		WsWorkunitsStub stub = platform.getWsWorkunitsService();
		if (stub != null) {
			WUInfo request = new WUInfo();
			request.setWuid(info.getWuid());
			request.setIncludeGraphs(includeGraphs);
			request.setIncludeResults(includeResults);
			request.setIncludeResultsViewNames(includeResults);
			request.setSuppressResultSchemas(!includeResults);
			request.setIncludeSourceFiles(includeSourceFiles);
			request.setIncludeApplicationValues(includeApplicationValues);
			try {
				WUInfoResponse response = stub.wUInfo(request);
				if (response.getWorkunit() == null) {	//  Call succeeded, but no response...
					for (EspException e : response.getExceptions().getException()) {
						if (e.getCode().equals("20082")) {	//  No longer exists...
							info.setStateID(999);	
							setChanged();
							notifyObservers(Notification.WORKUNIT);
							break;
						}
					}

				} else {
					update(response.getWorkunit());
				}
				if (response.getResultViews() != null && response.getResultViews().getView() != null) {
					resultViews = Arrays.asList(response.getResultViews().getView());
				} 
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (EspSoapFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//  Updates  ---
	boolean update(ECLWorkunit wu) {		
		boolean retVal = false;
		if (wu != null && info.getWuid().equals(wu.getWuid()) && !info.equals(wu)) {
			if (updateState(wu)) {
				retVal = true;
				notifyObservers(Notification.WORKUNIT);
			}
			if (updateJobname(wu.getJobname())) {
				retVal = true;
				notifyObservers(Notification.JOBNAME);
			}
			if (updateCluster(wu.getCluster())) {
				retVal = true;
				notifyObservers(Notification.CLUSTER);
			}
			if (updateQuery(wu.getQuery())) {
				retVal = true;
				notifyObservers(Notification.QUERY);
			}
			if (updateApplicationValues(wu.getApplicationValues())) {
				retVal = true;
				notifyObservers(Notification.APPLICATIONVALUES);
			}
			if (updateResults(wu.getResults())) {
				retVal = true;
				notifyObservers(Notification.RESULTS);
			}
			if (updateGraphs(wu.getGraphs())) {
				retVal = true;
				notifyObservers(Notification.GRAPHS);
			}
			if (updateSourceFiles(wu.getSourceFiles())) {
				retVal = true;
				notifyObservers(Notification.SOURCEFILES);
			}
		}
		monitor();
		return retVal;
	}

	synchronized boolean updateState(ECLWorkunit wu) {
		boolean retVal = false;
		if (wu != null && info.getWuid().equals(wu.getWuid())
				&& EqualsUtil.hasChanged(info.getStateID(), wu.getStateID())) {
			info.setStateID(wu.getStateID());
			info.setStateEx(wu.getStateEx());
			info.setState(wu.getState());
			setChanged();
			retVal = true;
		}
		return retVal;
	}

	synchronized boolean updateCluster(String cluster) {
		if (cluster != null && EqualsUtil.hasChanged(info.getCluster(), cluster)) {
			info.setCluster(cluster);
			setChanged();
			return true;
		}
		return false;
	}

	synchronized boolean updateJobname(String jobname) {
		if (jobname != null && EqualsUtil.hasChanged(info.getJobname(), jobname)) {
			info.setJobname(jobname);
			setChanged();
			return true;
		}
		return false;
	}

	synchronized boolean updateQuery(ECLQuery q) {
		if (q != null && EqualsUtil.hasChanged(info.getQuery(), q)) {
			info.setQuery(q);
			setChanged();
			return true;
		}
		return false;
	}

	synchronized boolean updateApplicationValues(ArrayOfApplicationValue rawAppVals) {
		if (rawAppVals != null) {
			int applicationValuesCount = applicationValues.size();
			//  Prime results;
			applicationValues.clear();
			for(ApplicationValue av : rawAppVals.getApplicationValue()) {
				if (av.getApplication().compareTo(Activator.PLUGIN_ID) == 0) {
					applicationValues.put(av.getName(), av.getValue());
				}
			}
			if (applicationValuesCount != applicationValues.size()) {
				setChanged();
				return true;
			}
		}
		return false;
	}

	synchronized boolean updateResults(ArrayOfECLResult rawResults) {
		if (rawResults != null) {
			int resultCount = results.size();
			//  Prime results;
			results.clear();
			for(ECLResult r : rawResults.getECLResult()) {
				results.add(getResult(r)); 	//  Will mark changed if needed  ---
			}
			if (resultCount != results.size()) {
				setChanged();
				return true;
			}
		}
		return false;
	}

	synchronized boolean updateGraphs(ArrayOfECLGraph rawGraphs) {
		if (rawGraphs != null) {
			int graphCount = graphs.size();
			//  Prime graphs;
			graphs.clear();
			for(ECLGraph g : rawGraphs.getECLGraph()) {
				graphs.add(getGraph(g));	//  Will mark changed if needed  ---
			}
			if (graphCount != graphs.size()) {
				setChanged();
				return true;
			}
		}
		return false;
	}

	synchronized boolean updateSourceFiles(ArrayOfECLSourceFile rawSourceFiles) {
		if (rawSourceFiles != null) {
			int sourceFileCount = sourceFiles.size();
			//  Prime graphs;
			sourceFiles.clear();
			for(ECLSourceFile g : rawSourceFiles.getECLSourceFile()) {
				sourceFiles.add(getSourceFile(g));	//  Will mark changed if needed  ---
			}
			if (sourceFileCount != sourceFiles.size()) {
				setChanged();
				return true;
			}
		}
		return false;
	}

	@Override 
	public boolean equals(Object aThat) {
		if ( this == aThat ) {
			return true;
		}

		if ( !(aThat instanceof Workunit) ) {
			return false;
		}
		Workunit that = (Workunit)aThat;

		//now a proper field-by-field evaluation can be made
		return EqualsUtil.areEqual(platform, that.platform) &&
				EqualsUtil.areEqual(info.getWuid(), that.info.getWuid());
	}

	@Override
	public int hashCode() {
		int result = HashCodeUtil.SEED;
		result = HashCodeUtil.hash(result, platform);
		result = HashCodeUtil.hash(result, info.getWuid());
		return result;
	}
}

