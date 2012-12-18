
/**
 * WsTopologyCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package org.hpccsystems.ws.wstopology;

    /**
     *  WsTopologyCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class WsTopologyCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public WsTopologyCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public WsTopologyCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for tpGroupQuery method
            * override this method for handling normal response from tpGroupQuery operation
            */
           public void receiveResulttpGroupQuery(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.TpGroupQueryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tpGroupQuery operation
           */
            public void receiveErrortpGroupQuery(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for tpLogicalClusterQuery method
            * override this method for handling normal response from tpLogicalClusterQuery operation
            */
           public void receiveResulttpLogicalClusterQuery(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.TpLogicalClusterQueryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tpLogicalClusterQuery operation
           */
            public void receiveErrortpLogicalClusterQuery(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for tpClusterInfo method
            * override this method for handling normal response from tpClusterInfo operation
            */
           public void receiveResulttpClusterInfo(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.TpClusterInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tpClusterInfo operation
           */
            public void receiveErrortpClusterInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for tpGetComponentFile method
            * override this method for handling normal response from tpGetComponentFile operation
            */
           public void receiveResulttpGetComponentFile(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.TpGetComponentFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tpGetComponentFile operation
           */
            public void receiveErrortpGetComponentFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for systemLog method
            * override this method for handling normal response from systemLog operation
            */
           public void receiveResultsystemLog(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.SystemLogResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from systemLog operation
           */
            public void receiveErrorsystemLog(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for tpSwapNode method
            * override this method for handling normal response from tpSwapNode operation
            */
           public void receiveResulttpSwapNode(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.TpSwapNodeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tpSwapNode operation
           */
            public void receiveErrortpSwapNode(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for tpSetMachineStatus method
            * override this method for handling normal response from tpSetMachineStatus operation
            */
           public void receiveResulttpSetMachineStatus(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.TpSetMachineStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tpSetMachineStatus operation
           */
            public void receiveErrortpSetMachineStatus(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for tpLogFile method
            * override this method for handling normal response from tpLogFile operation
            */
           public void receiveResulttpLogFile(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.TpLogFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tpLogFile operation
           */
            public void receiveErrortpLogFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for tpThorStatus method
            * override this method for handling normal response from tpThorStatus operation
            */
           public void receiveResulttpThorStatus(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.TpThorStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tpThorStatus operation
           */
            public void receiveErrortpThorStatus(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for tpTargetClusterQuery method
            * override this method for handling normal response from tpTargetClusterQuery operation
            */
           public void receiveResulttpTargetClusterQuery(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.TpTargetClusterQueryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tpTargetClusterQuery operation
           */
            public void receiveErrortpTargetClusterQuery(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for tpXMLFile method
            * override this method for handling normal response from tpXMLFile operation
            */
           public void receiveResulttpXMLFile(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.TpXMLFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tpXMLFile operation
           */
            public void receiveErrortpXMLFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for tpLogFileDisplay method
            * override this method for handling normal response from tpLogFileDisplay operation
            */
           public void receiveResulttpLogFileDisplay(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.TpLogFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tpLogFileDisplay operation
           */
            public void receiveErrortpLogFileDisplay(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for tpMachineQuery method
            * override this method for handling normal response from tpMachineQuery operation
            */
           public void receiveResulttpMachineQuery(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.TpMachineQueryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tpMachineQuery operation
           */
            public void receiveErrortpMachineQuery(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for tpClusterQuery method
            * override this method for handling normal response from tpClusterQuery operation
            */
           public void receiveResulttpClusterQuery(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.TpClusterQueryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tpClusterQuery operation
           */
            public void receiveErrortpClusterQuery(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for tpServiceQuery method
            * override this method for handling normal response from tpServiceQuery operation
            */
           public void receiveResulttpServiceQuery(
                    org.hpccsystems.ws.wstopology.WsTopologyStub.TpServiceQueryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tpServiceQuery operation
           */
            public void receiveErrortpServiceQuery(java.lang.Exception e) {
            }
                


    }
    