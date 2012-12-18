
/**
 * EspSoapFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package org.hpccsystems.ws.wsworkunits;

public class EspSoapFault extends java.lang.Exception{

    private static final long serialVersionUID = 1355736288340L;
    
    private org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.Exceptions faultMessage;

    
        public EspSoapFault() {
            super("EspSoapFault");
        }

        public EspSoapFault(java.lang.String s) {
           super(s);
        }

        public EspSoapFault(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public EspSoapFault(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.Exceptions msg){
       faultMessage = msg;
    }
    
    public org.hpccsystems.ws.wsworkunits.WsWorkunitsStub.Exceptions getFaultMessage(){
       return faultMessage;
    }
}
    