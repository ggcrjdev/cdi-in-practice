package practice.cdi.jaxws;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import practice.cdi.HelpCDIService;
import practice.cdi.ejb.HelpEJBService;

/**
 * <p>
 * Titulo: HelpSoapEndpoint.java
 * </p>
 * <p>
 * Descrição:
 * </p>
 * <br>
 * <b>Company:</b> FINEP - Projfin 30 Dias
 * 
 * @date 29/03/2016
 * @autor gustavo.conceicao
 * 
 */
// @Stateless(name = "HelpSoapStateless")
@WebService(portName = "HelpSoapPort", serviceName = "HelpSoapService", name = "HelpWS", targetNamespace = "http://localhost:8080")
public class HelpSoap {

    @Inject
    HelpCDIService helpCDIService;

    @Inject
    HelpEJBService helpEJBService;

    @WebMethod
    public String ping() {
        return helpCDIService.ping();
    }
}
