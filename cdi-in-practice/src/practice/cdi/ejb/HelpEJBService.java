package practice.cdi.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * <p>
 * Titulo: HelpCDIService.java
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
@Stateless
public class HelpEJBService {

    @Inject
    AnotherHelpEJBService anotherHelpEJBService;

    public String ping() {
        return anotherHelpEJBService.ping();
    }

    public String displayWelcomeMessage() {
        return "Welcome!";
    }
}
