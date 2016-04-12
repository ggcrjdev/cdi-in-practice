package practice.cdi;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ResourceBundle;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Qualifier;

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
@Dependent
public class HelpCDIService {

    @Qualifier
    @Target({ TYPE, METHOD, PARAMETER, FIELD })
    @Retention(RUNTIME)
    public @interface WelcomeMessagePropertyValue {
    }

    @Produces
    @WelcomeMessagePropertyValue
    String getWelcomeMessagePropertyValue() {
        return (String) ResourceBundle.getBundle("foo").getObject("welcome.message");
    }

    public String ping() {
        return "Pong CDI";
    }
}
