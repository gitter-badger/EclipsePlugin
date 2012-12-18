
/**
 * FileSprayCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package org.hpccsystems.ws.filespray;

    /**
     *  FileSprayCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class FileSprayCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public FileSprayCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public FileSprayCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for dFUWUSearch method
            * override this method for handling normal response from dFUWUSearch operation
            */
           public void receiveResultdFUWUSearch(
                    org.hpccsystems.ws.filespray.FileSprayStub.DFUWUSearchResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dFUWUSearch operation
           */
            public void receiveErrordFUWUSearch(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for submitDFUWorkunit method
            * override this method for handling normal response from submitDFUWorkunit operation
            */
           public void receiveResultsubmitDFUWorkunit(
                    org.hpccsystems.ws.filespray.FileSprayStub.SubmitDFUWorkunitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from submitDFUWorkunit operation
           */
            public void receiveErrorsubmitDFUWorkunit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateDFUWorkunit method
            * override this method for handling normal response from updateDFUWorkunit operation
            */
           public void receiveResultupdateDFUWorkunit(
                    org.hpccsystems.ws.filespray.FileSprayStub.UpdateDFUWorkunitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateDFUWorkunit operation
           */
            public void receiveErrorupdateDFUWorkunit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDFUWorkunits method
            * override this method for handling normal response from getDFUWorkunits operation
            */
           public void receiveResultgetDFUWorkunits(
                    org.hpccsystems.ws.filespray.FileSprayStub.GetDFUWorkunitsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDFUWorkunits operation
           */
            public void receiveErrorgetDFUWorkunits(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDFUProgress method
            * override this method for handling normal response from getDFUProgress operation
            */
           public void receiveResultgetDFUProgress(
                    org.hpccsystems.ws.filespray.FileSprayStub.ProgressResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDFUProgress operation
           */
            public void receiveErrorgetDFUProgress(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createDFUWorkunit method
            * override this method for handling normal response from createDFUWorkunit operation
            */
           public void receiveResultcreateDFUWorkunit(
                    org.hpccsystems.ws.filespray.FileSprayStub.CreateDFUWorkunitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createDFUWorkunit operation
           */
            public void receiveErrorcreateDFUWorkunit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteDropZoneFiles method
            * override this method for handling normal response from deleteDropZoneFiles operation
            */
           public void receiveResultdeleteDropZoneFiles(
                    org.hpccsystems.ws.filespray.FileSprayStub.DFUWorkunitsActionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteDropZoneFiles operation
           */
            public void receiveErrordeleteDropZoneFiles(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for echoDateTime method
            * override this method for handling normal response from echoDateTime operation
            */
           public void receiveResultechoDateTime(
                    org.hpccsystems.ws.filespray.FileSprayStub.EchoDateTimeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from echoDateTime operation
           */
            public void receiveErrorechoDateTime(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dFUWorkunitsAction method
            * override this method for handling normal response from dFUWorkunitsAction operation
            */
           public void receiveResultdFUWorkunitsAction(
                    org.hpccsystems.ws.filespray.FileSprayStub.DFUWorkunitsActionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dFUWorkunitsAction operation
           */
            public void receiveErrordFUWorkunitsAction(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sprayVariable method
            * override this method for handling normal response from sprayVariable operation
            */
           public void receiveResultsprayVariable(
                    org.hpccsystems.ws.filespray.FileSprayStub.SprayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sprayVariable operation
           */
            public void receiveErrorsprayVariable(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dFUWUFile method
            * override this method for handling normal response from dFUWUFile operation
            */
           public void receiveResultdFUWUFile(
                    org.hpccsystems.ws.filespray.FileSprayStub.DFUWUFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dFUWUFile operation
           */
            public void receiveErrordFUWUFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for despray method
            * override this method for handling normal response from despray operation
            */
           public void receiveResultdespray(
                    org.hpccsystems.ws.filespray.FileSprayStub.DesprayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from despray operation
           */
            public void receiveErrordespray(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for showResult method
            * override this method for handling normal response from showResult operation
            */
           public void receiveResultshowResult(
                    org.hpccsystems.ws.filespray.FileSprayStub.ShowResultResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from showResult operation
           */
            public void receiveErrorshowResult(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteDFUWorkunit method
            * override this method for handling normal response from deleteDFUWorkunit operation
            */
           public void receiveResultdeleteDFUWorkunit(
                    org.hpccsystems.ws.filespray.FileSprayStub.DeleteDFUWorkunitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteDFUWorkunit operation
           */
            public void receiveErrordeleteDFUWorkunit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDFUWorkunit method
            * override this method for handling normal response from getDFUWorkunit operation
            */
           public void receiveResultgetDFUWorkunit(
                    org.hpccsystems.ws.filespray.FileSprayStub.GetDFUWorkunitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDFUWorkunit operation
           */
            public void receiveErrorgetDFUWorkunit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for fileList method
            * override this method for handling normal response from fileList operation
            */
           public void receiveResultfileList(
                    org.hpccsystems.ws.filespray.FileSprayStub.FileListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from fileList operation
           */
            public void receiveErrorfileList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for openSave method
            * override this method for handling normal response from openSave operation
            */
           public void receiveResultopenSave(
                    org.hpccsystems.ws.filespray.FileSprayStub.OpenSaveResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from openSave operation
           */
            public void receiveErroropenSave(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for replicate method
            * override this method for handling normal response from replicate operation
            */
           public void receiveResultreplicate(
                    org.hpccsystems.ws.filespray.FileSprayStub.ReplicateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from replicate operation
           */
            public void receiveErrorreplicate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteDFUWorkunits method
            * override this method for handling normal response from deleteDFUWorkunits operation
            */
           public void receiveResultdeleteDFUWorkunits(
                    org.hpccsystems.ws.filespray.FileSprayStub.DeleteDFUWorkunitsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteDFUWorkunits operation
           */
            public void receiveErrordeleteDFUWorkunits(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sprayFixed method
            * override this method for handling normal response from sprayFixed operation
            */
           public void receiveResultsprayFixed(
                    org.hpccsystems.ws.filespray.FileSprayStub.SprayFixedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sprayFixed operation
           */
            public void receiveErrorsprayFixed(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for rename method
            * override this method for handling normal response from rename operation
            */
           public void receiveResultrename(
                    org.hpccsystems.ws.filespray.FileSprayStub.RenameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from rename operation
           */
            public void receiveErrorrename(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for abortDFUWorkunit method
            * override this method for handling normal response from abortDFUWorkunit operation
            */
           public void receiveResultabortDFUWorkunit(
                    org.hpccsystems.ws.filespray.FileSprayStub.AbortDFUWorkunitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from abortDFUWorkunit operation
           */
            public void receiveErrorabortDFUWorkunit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for copy method
            * override this method for handling normal response from copy operation
            */
           public void receiveResultcopy(
                    org.hpccsystems.ws.filespray.FileSprayStub.CopyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from copy operation
           */
            public void receiveErrorcopy(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dfuMonitor method
            * override this method for handling normal response from dfuMonitor operation
            */
           public void receiveResultdfuMonitor(
                    org.hpccsystems.ws.filespray.FileSprayStub.DfuMonitorResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dfuMonitor operation
           */
            public void receiveErrordfuMonitor(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for dropZoneFiles method
            * override this method for handling normal response from dropZoneFiles operation
            */
           public void receiveResultdropZoneFiles(
                    org.hpccsystems.ws.filespray.FileSprayStub.DropZoneFilesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from dropZoneFiles operation
           */
            public void receiveErrordropZoneFiles(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDFUExceptions method
            * override this method for handling normal response from getDFUExceptions operation
            */
           public void receiveResultgetDFUExceptions(
                    org.hpccsystems.ws.filespray.FileSprayStub.GetDFUExceptionsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDFUExceptions operation
           */
            public void receiveErrorgetDFUExceptions(java.lang.Exception e) {
            }
                


    }
    