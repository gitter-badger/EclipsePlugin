
/**
 * WsAttributesCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package org.hpccsystems.ws.WsAttributes;

    /**
     *  WsAttributesCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class WsAttributesCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public WsAttributesCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public WsAttributesCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for deleteModule method
            * override this method for handling normal response from deleteModule operation
            */
           public void receiveResultdeleteModule(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.DeleteModuleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteModule operation
           */
            public void receiveErrordeleteModule(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteAttributes method
            * override this method for handling normal response from deleteAttributes operation
            */
           public void receiveResultdeleteAttributes(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.UpdateAttributesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteAttributes operation
           */
            public void receiveErrordeleteAttributes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for checkoutAttributes method
            * override this method for handling normal response from checkoutAttributes operation
            */
           public void receiveResultcheckoutAttributes(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.UpdateAttributesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkoutAttributes operation
           */
            public void receiveErrorcheckoutAttributes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createAttribute method
            * override this method for handling normal response from createAttribute operation
            */
           public void receiveResultcreateAttribute(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.CreateAttributeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createAttribute operation
           */
            public void receiveErrorcreateAttribute(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for supportsEarMark method
            * override this method for handling normal response from supportsEarMark operation
            */
           public void receiveResultsupportsEarMark(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.SupportsEarMarkResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from supportsEarMark operation
           */
            public void receiveErrorsupportsEarMark(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for checkinAttributes method
            * override this method for handling normal response from checkinAttributes operation
            */
           public void receiveResultcheckinAttributes(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.UpdateAttributesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkinAttributes operation
           */
            public void receiveErrorcheckinAttributes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateLabel method
            * override this method for handling normal response from updateLabel operation
            */
           public void receiveResultupdateLabel(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.UpdateLabelResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateLabel operation
           */
            public void receiveErrorupdateLabel(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for importAttributes method
            * override this method for handling normal response from importAttributes operation
            */
           public void receiveResultimportAttributes(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.UpdateAttributesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from importAttributes operation
           */
            public void receiveErrorimportAttributes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAttributes method
            * override this method for handling normal response from getAttributes operation
            */
           public void receiveResultgetAttributes(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.GetAttributesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAttributes operation
           */
            public void receiveErrorgetAttributes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getModules method
            * override this method for handling normal response from getModules operation
            */
           public void receiveResultgetModules(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.GetModulesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getModules operation
           */
            public void receiveErrorgetModules(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for saveAttributes method
            * override this method for handling normal response from saveAttributes operation
            */
           public void receiveResultsaveAttributes(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.UpdateAttributesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from saveAttributes operation
           */
            public void receiveErrorsaveAttributes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getLabels method
            * override this method for handling normal response from getLabels operation
            */
           public void receiveResultgetLabels(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.GetLabelsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getLabels operation
           */
            public void receiveErrorgetLabels(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAttribute method
            * override this method for handling normal response from getAttribute operation
            */
           public void receiveResultgetAttribute(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.GetAttributeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAttribute operation
           */
            public void receiveErrorgetAttribute(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for renameAttributes method
            * override this method for handling normal response from renameAttributes operation
            */
           public void receiveResultrenameAttributes(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.UpdateAttributesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from renameAttributes operation
           */
            public void receiveErrorrenameAttributes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAttributeHistory method
            * override this method for handling normal response from getAttributeHistory operation
            */
           public void receiveResultgetAttributeHistory(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.GetAttributeHistoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAttributeHistory operation
           */
            public void receiveErrorgetAttributeHistory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createLabel method
            * override this method for handling normal response from createLabel operation
            */
           public void receiveResultcreateLabel(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.CreateLabelResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createLabel operation
           */
            public void receiveErrorcreateLabel(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteLabel method
            * override this method for handling normal response from deleteLabel operation
            */
           public void receiveResultdeleteLabel(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.DeleteLabelResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteLabel operation
           */
            public void receiveErrordeleteLabel(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAttributeLabels method
            * override this method for handling normal response from getAttributeLabels operation
            */
           public void receiveResultgetAttributeLabels(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.GetAttributeLabelsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAttributeLabels operation
           */
            public void receiveErrorgetAttributeLabels(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for renameModule method
            * override this method for handling normal response from renameModule operation
            */
           public void receiveResultrenameModule(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.RenameModuleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from renameModule operation
           */
            public void receiveErrorrenameModule(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findAttributes method
            * override this method for handling normal response from findAttributes operation
            */
           public void receiveResultfindAttributes(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.FindAttributesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findAttributes operation
           */
            public void receiveErrorfindAttributes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for rollbackAttributes method
            * override this method for handling normal response from rollbackAttributes operation
            */
           public void receiveResultrollbackAttributes(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.UpdateAttributesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from rollbackAttributes operation
           */
            public void receiveErrorrollbackAttributes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createModule method
            * override this method for handling normal response from createModule operation
            */
           public void receiveResultcreateModule(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.CreateModuleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createModule operation
           */
            public void receiveErrorcreateModule(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listAttributeTypes method
            * override this method for handling normal response from listAttributeTypes operation
            */
           public void receiveResultlistAttributeTypes(
                    org.hpccsystems.ws.WsAttributes.WsAttributesStub.ListAttributeTypesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listAttributeTypes operation
           */
            public void receiveErrorlistAttributeTypes(java.lang.Exception e) {
            }
                


    }
    