package practice.cdi.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import practice.cdi.ejb.HelpEJBService;

/**
 * <p>
 * Titulo: FooController.java
 * </p>
 * <p>
 * Descrição:
 * </p>
 * <br>
 * <b>Company:</b> FINEP - Projfin 30 Dias
 * 
 * @date 11/04/2016
 * @autor gustavo.conceicao
 * 
 */
@ManagedBean
@ViewScoped
public class FooManagedBeanController {

    @Inject
    HelpEJBService helpEJBService;

    public String displayWelcomeMessage() {
        return helpEJBService.displayWelcomeMessage();
    }
}
