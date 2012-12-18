
/**
 * WsWorkunitsCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package org.hpccsystems.ws.wsworkunits;

    /**
     *  WsWorkunitsCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class WsWorkunitsCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public WsWorkunitsCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public WsWorkunitsCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for wUCopyLogicalFiles method
            * override this method for handling normal response from wUCopyLogicalFiles operation
            */
           public void receiveResultwUCopyLogicalFiles(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUCopyLogicalFilesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUCopyLogicalFiles operation
           */
            public void receiveErrorwUCopyLogicalFiles(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUQuerysetCopyQuery method
            * override this method for handling normal response from wUQuerysetCopyQuery operation
            */
           public void receiveResultwUQuerysetCopyQuery(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUQuerySetCopyQueryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUQuerysetCopyQuery operation
           */
            public void receiveErrorwUQuerysetCopyQuery(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUPushEvent method
            * override this method for handling normal response from wUPushEvent operation
            */
           public void receiveResultwUPushEvent(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUPushEventResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUPushEvent operation
           */
            public void receiveErrorwUPushEvent(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUFile method
            * override this method for handling normal response from wUFile operation
            */
           public void receiveResultwUFile(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WULogFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUFile operation
           */
            public void receiveErrorwUFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUQuery method
            * override this method for handling normal response from wUQuery operation
            */
           public void receiveResultwUQuery(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUQueryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUQuery operation
           */
            public void receiveErrorwUQuery(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUWaitComplete method
            * override this method for handling normal response from wUWaitComplete operation
            */
           public void receiveResultwUWaitComplete(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUWaitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUWaitComplete operation
           */
            public void receiveErrorwUWaitComplete(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUResubmit method
            * override this method for handling normal response from wUResubmit operation
            */
           public void receiveResultwUResubmit(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUResubmitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUResubmit operation
           */
            public void receiveErrorwUResubmit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUClusterJobQueueXLS method
            * override this method for handling normal response from wUClusterJobQueueXLS operation
            */
           public void receiveResultwUClusterJobQueueXLS(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUClusterJobQueueXLSResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUClusterJobQueueXLS operation
           */
            public void receiveErrorwUClusterJobQueueXLS(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUCompileECL method
            * override this method for handling normal response from wUCompileECL operation
            */
           public void receiveResultwUCompileECL(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUCompileECLResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUCompileECL operation
           */
            public void receiveErrorwUCompileECL(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUClusterJobSummaryXLS method
            * override this method for handling normal response from wUClusterJobSummaryXLS operation
            */
           public void receiveResultwUClusterJobSummaryXLS(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUClusterJobSummaryXLSResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUClusterJobSummaryXLS operation
           */
            public void receiveErrorwUClusterJobSummaryXLS(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUGraphInfo method
            * override this method for handling normal response from wUGraphInfo operation
            */
           public void receiveResultwUGraphInfo(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUGraphInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUGraphInfo operation
           */
            public void receiveErrorwUGraphInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUCreateAndUpdate method
            * override this method for handling normal response from wUCreateAndUpdate operation
            */
           public void receiveResultwUCreateAndUpdate(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUUpdateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUCreateAndUpdate operation
           */
            public void receiveErrorwUCreateAndUpdate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUClusterJobQueueLOG method
            * override this method for handling normal response from wUClusterJobQueueLOG operation
            */
           public void receiveResultwUClusterJobQueueLOG(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUClusterJobQueueLOGResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUClusterJobQueueLOG operation
           */
            public void receiveErrorwUClusterJobQueueLOG(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUExport method
            * override this method for handling normal response from wUExport operation
            */
           public void receiveResultwUExport(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUExportResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUExport operation
           */
            public void receiveErrorwUExport(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUAddLocalFileToWorkunit method
            * override this method for handling normal response from wUAddLocalFileToWorkunit operation
            */
           public void receiveResultwUAddLocalFileToWorkunit(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUAddLocalFileToWorkunitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUAddLocalFileToWorkunit operation
           */
            public void receiveErrorwUAddLocalFileToWorkunit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUInfoDetails method
            * override this method for handling normal response from wUInfoDetails operation
            */
           public void receiveResultwUInfoDetails(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUInfoDetails operation
           */
            public void receiveErrorwUInfoDetails(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUClusterJobXLS method
            * override this method for handling normal response from wUClusterJobXLS operation
            */
           public void receiveResultwUClusterJobXLS(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUClusterJobXLSResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUClusterJobXLS operation
           */
            public void receiveErrorwUClusterJobXLS(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUQuerysetQueryAction method
            * override this method for handling normal response from wUQuerysetQueryAction operation
            */
           public void receiveResultwUQuerysetQueryAction(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUQuerySetQueryActionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUQuerysetQueryAction operation
           */
            public void receiveErrorwUQuerysetQueryAction(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUListLocalFileRequired method
            * override this method for handling normal response from wUListLocalFileRequired operation
            */
           public void receiveResultwUListLocalFileRequired(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUListLocalFileRequiredResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUListLocalFileRequired operation
           */
            public void receiveErrorwUListLocalFileRequired(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUDeployWorkunit method
            * override this method for handling normal response from wUDeployWorkunit operation
            */
           public void receiveResultwUDeployWorkunit(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUDeployWorkunitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUDeployWorkunit operation
           */
            public void receiveErrorwUDeployWorkunit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUGetDependancyTrees method
            * override this method for handling normal response from wUGetDependancyTrees operation
            */
           public void receiveResultwUGetDependancyTrees(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUGetDependancyTreesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUGetDependancyTrees operation
           */
            public void receiveErrorwUGetDependancyTrees(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUGVCGraphInfo method
            * override this method for handling normal response from wUGVCGraphInfo operation
            */
           public void receiveResultwUGVCGraphInfo(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUGVCGraphInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUGVCGraphInfo operation
           */
            public void receiveErrorwUGVCGraphInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUSchedule method
            * override this method for handling normal response from wUSchedule operation
            */
           public void receiveResultwUSchedule(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUScheduleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUSchedule operation
           */
            public void receiveErrorwUSchedule(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUAbort method
            * override this method for handling normal response from wUAbort operation
            */
           public void receiveResultwUAbort(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUAbortResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUAbort operation
           */
            public void receiveErrorwUAbort(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUShowScheduled method
            * override this method for handling normal response from wUShowScheduled operation
            */
           public void receiveResultwUShowScheduled(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUShowScheduledResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUShowScheduled operation
           */
            public void receiveErrorwUShowScheduled(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUResult method
            * override this method for handling normal response from wUResult operation
            */
           public void receiveResultwUResult(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUResultResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUResult operation
           */
            public void receiveErrorwUResult(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUAction method
            * override this method for handling normal response from wUAction operation
            */
           public void receiveResultwUAction(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUActionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUAction operation
           */
            public void receiveErrorwUAction(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUQuerysets method
            * override this method for handling normal response from wUQuerysets operation
            */
           public void receiveResultwUQuerysets(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUQuerysetsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUQuerysets operation
           */
            public void receiveErrorwUQuerysets(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUGetGraph method
            * override this method for handling normal response from wUGetGraph operation
            */
           public void receiveResultwUGetGraph(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUGetGraphResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUGetGraph operation
           */
            public void receiveErrorwUGetGraph(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for gVCAjaxGraph method
            * override this method for handling normal response from gVCAjaxGraph operation
            */
           public void receiveResultgVCAjaxGraph(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.GVCAjaxGraphResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from gVCAjaxGraph operation
           */
            public void receiveErrorgVCAjaxGraph(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUJobList method
            * override this method for handling normal response from wUJobList operation
            */
           public void receiveResultwUJobList(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUJobListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUJobList operation
           */
            public void receiveErrorwUJobList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUProcessGraph method
            * override this method for handling normal response from wUProcessGraph operation
            */
           public void receiveResultwUProcessGraph(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUProcessGraphResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUProcessGraph operation
           */
            public void receiveErrorwUProcessGraph(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUCreate method
            * override this method for handling normal response from wUCreate operation
            */
           public void receiveResultwUCreate(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUCreateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUCreate operation
           */
            public void receiveErrorwUCreate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUWaitCompiled method
            * override this method for handling normal response from wUWaitCompiled operation
            */
           public void receiveResultwUWaitCompiled(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUWaitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUWaitCompiled operation
           */
            public void receiveErrorwUWaitCompiled(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUCDebug method
            * override this method for handling normal response from wUCDebug operation
            */
           public void receiveResultwUCDebug(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUDebugResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUCDebug operation
           */
            public void receiveErrorwUCDebug(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUInfo method
            * override this method for handling normal response from wUInfo operation
            */
           public void receiveResultwUInfo(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUInfo operation
           */
            public void receiveErrorwUInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUSubmit method
            * override this method for handling normal response from wUSubmit operation
            */
           public void receiveResultwUSubmit(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUSubmitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUSubmit operation
           */
            public void receiveErrorwUSubmit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUResultBin method
            * override this method for handling normal response from wUResultBin operation
            */
           public void receiveResultwUResultBin(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUResultBinResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUResultBin operation
           */
            public void receiveErrorwUResultBin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUResultSummary method
            * override this method for handling normal response from wUResultSummary operation
            */
           public void receiveResultwUResultSummary(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUResultSummaryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUResultSummary operation
           */
            public void receiveErrorwUResultSummary(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUGraphTiming method
            * override this method for handling normal response from wUGraphTiming operation
            */
           public void receiveResultwUGraphTiming(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUGraphTimingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUGraphTiming operation
           */
            public void receiveErrorwUGraphTiming(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUUpdate method
            * override this method for handling normal response from wUUpdate operation
            */
           public void receiveResultwUUpdate(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUUpdateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUUpdate operation
           */
            public void receiveErrorwUUpdate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUSyntaxCheckECL method
            * override this method for handling normal response from wUSyntaxCheckECL operation
            */
           public void receiveResultwUSyntaxCheckECL(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUSyntaxCheckResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUSyntaxCheckECL operation
           */
            public void receiveErrorwUSyntaxCheckECL(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUPublishWorkunit method
            * override this method for handling normal response from wUPublishWorkunit operation
            */
           public void receiveResultwUPublishWorkunit(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUPublishWorkunitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUPublishWorkunit operation
           */
            public void receiveErrorwUPublishWorkunit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUDelete method
            * override this method for handling normal response from wUDelete operation
            */
           public void receiveResultwUDelete(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUDeleteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUDelete operation
           */
            public void receiveErrorwUDelete(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUResultView method
            * override this method for handling normal response from wUResultView operation
            */
           public void receiveResultwUResultView(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUResultViewResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUResultView operation
           */
            public void receiveErrorwUResultView(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUQuerysetDetails method
            * override this method for handling normal response from wUQuerysetDetails operation
            */
           public void receiveResultwUQuerysetDetails(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUQuerySetDetailsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUQuerysetDetails operation
           */
            public void receiveErrorwUQuerysetDetails(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUProtect method
            * override this method for handling normal response from wUProtect operation
            */
           public void receiveResultwUProtect(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUProtectResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUProtect operation
           */
            public void receiveErrorwUProtect(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wURun method
            * override this method for handling normal response from wURun operation
            */
           public void receiveResultwURun(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WURunResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wURun operation
           */
            public void receiveErrorwURun(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUQuerysetAliasAction method
            * override this method for handling normal response from wUQuerysetAliasAction operation
            */
           public void receiveResultwUQuerysetAliasAction(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUQuerySetAliasActionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUQuerysetAliasAction operation
           */
            public void receiveErrorwUQuerysetAliasAction(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for wUMultiQuerysetDetails method
            * override this method for handling normal response from wUMultiQuerysetDetails operation
            */
           public void receiveResultwUMultiQuerysetDetails(
                    org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.WUMultiQuerySetDetailsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from wUMultiQuerysetDetails operation
           */
            public void receiveErrorwUMultiQuerysetDetails(java.lang.Exception e) {
            }
                


    }
    