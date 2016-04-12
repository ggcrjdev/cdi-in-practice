package practice.cdi.ejb;

import javax.ejb.Stateless;

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
public class AnotherHelpEJBService {

    public String ping() {
        return "Pong AnotherEJB";
    }
}
