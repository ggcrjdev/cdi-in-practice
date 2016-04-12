package practice.cdi.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

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
@Named
@RequestScoped
public class FooController {

    public String displayWelcomeMessage() {
        return "Welcome!";
    }
}
