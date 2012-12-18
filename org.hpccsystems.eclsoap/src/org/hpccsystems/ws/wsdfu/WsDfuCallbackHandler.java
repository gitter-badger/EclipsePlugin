
/**
 * WsDfuCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package org.hpccsystems.ws.wsdfu;

    /**
     *  WsDfuCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class WsDfuCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public WsDfuCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public WsDfuCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for dFUGetDataColumns method
            * override this method for handling normal response from dFUGetDataColumns operation
            */
           public void receiveResultdFUGetDataColumns(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.DFUGetDataColumnsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dFUGetDataColumns operation
           */
            public void receiveErrordFUGetDataColumns(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for add method
            * override this method for handling normal response from add operation
            */
           public void receiveResultadd(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.AddResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from add operation
           */
            public void receiveErroradd(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dFUArrayAction method
            * override this method for handling normal response from dFUArrayAction operation
            */
           public void receiveResultdFUArrayAction(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.DFUArrayActionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dFUArrayAction operation
           */
            public void receiveErrordFUArrayAction(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dFUQuery method
            * override this method for handling normal response from dFUQuery operation
            */
           public void receiveResultdFUQuery(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.DFUQueryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dFUQuery operation
           */
            public void receiveErrordFUQuery(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dFUSearchData method
            * override this method for handling normal response from dFUSearchData operation
            */
           public void receiveResultdFUSearchData(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.DFUSearchDataResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dFUSearchData operation
           */
            public void receiveErrordFUSearchData(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addRemote method
            * override this method for handling normal response from addRemote operation
            */
           public void receiveResultaddRemote(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.AddRemoteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addRemote operation
           */
            public void receiveErroraddRemote(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for savexml method
            * override this method for handling normal response from savexml operation
            */
           public void receiveResultsavexml(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.SavexmlResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from savexml operation
           */
            public void receiveErrorsavexml(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for superfileAction method
            * override this method for handling normal response from superfileAction operation
            */
           public void receiveResultsuperfileAction(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.SuperfileActionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from superfileAction operation
           */
            public void receiveErrorsuperfileAction(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for superfileAddRaw method
            * override this method for handling normal response from superfileAddRaw operation
            */
           public void receiveResultsuperfileAddRaw(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.SuperfileAddRawResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from superfileAddRaw operation
           */
            public void receiveErrorsuperfileAddRaw(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addtoSuperfile method
            * override this method for handling normal response from addtoSuperfile operation
            */
           public void receiveResultaddtoSuperfile(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.AddtoSuperfileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addtoSuperfile operation
           */
            public void receiveErroraddtoSuperfile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dFUSearch method
            * override this method for handling normal response from dFUSearch operation
            */
           public void receiveResultdFUSearch(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.DFUSearchResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dFUSearch operation
           */
            public void receiveErrordFUSearch(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dFUFileView method
            * override this method for handling normal response from dFUFileView operation
            */
           public void receiveResultdFUFileView(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.DFUFileViewResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dFUFileView operation
           */
            public void receiveErrordFUFileView(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dFUSpace method
            * override this method for handling normal response from dFUSpace operation
            */
           public void receiveResultdFUSpace(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.DFUSpaceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dFUSpace operation
           */
            public void receiveErrordFUSpace(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for superfileList method
            * override this method for handling normal response from superfileList operation
            */
           public void receiveResultsuperfileList(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.SuperfileListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from superfileList operation
           */
            public void receiveErrorsuperfileList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dFUInfo method
            * override this method for handling normal response from dFUInfo operation
            */
           public void receiveResultdFUInfo(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.DFUInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dFUInfo operation
           */
            public void receiveErrordFUInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dFUDefFile method
            * override this method for handling normal response from dFUDefFile operation
            */
           public void receiveResultdFUDefFile(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.DFUDefFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dFUDefFile operation
           */
            public void receiveErrordFUDefFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dFUBrowseData method
            * override this method for handling normal response from dFUBrowseData operation
            */
           public void receiveResultdFUBrowseData(
                    org.hpccsystems.ws.wsdfu.WsDfuStub.DFUBrowseDataResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dFUBrowseData operation
           */
            public void receiveErrordFUBrowseData(java.lang.Exception e) {
            }
                


    }
    