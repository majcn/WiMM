package org.example.invoiceservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2012-12-09T15:36:12.781+01:00
 * Generated source version: 2.7.0
 * 
 */
@WebServiceClient(name = "InvoiceService", 
                  wsdlLocation = "http://www.example.org/?wsdl",
                  targetNamespace = "http://www.example.org/InvoiceService/") 
public class InvoiceService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.example.org/InvoiceService/", "InvoiceService");
    public final static QName InvoiceServiceSOAP = new QName("http://www.example.org/InvoiceService/", "InvoiceServiceSOAP");
    static {
        URL url = null;
        try {
            url = new URL("http://www.example.org/?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(InvoiceService_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://www.example.org/?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public InvoiceService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public InvoiceService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public InvoiceService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns InvoiceService
     */
    @WebEndpoint(name = "InvoiceServiceSOAP")
    public InvoiceService getInvoiceServiceSOAP() {
        return super.getPort(InvoiceServiceSOAP, InvoiceService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns InvoiceService
     */
    @WebEndpoint(name = "InvoiceServiceSOAP")
    public InvoiceService getInvoiceServiceSOAP(WebServiceFeature... features) {
        return super.getPort(InvoiceServiceSOAP, InvoiceService.class, features);
    }

}
