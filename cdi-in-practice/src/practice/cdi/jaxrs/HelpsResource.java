package practice.cdi.jaxrs;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import practice.cdi.HelpCDIService;
import practice.cdi.HelpCDIService.WelcomeMessagePropertyValue;
import practice.cdi.ejb.HelpEJBService;
import practice.cdi.ejb.JavaEEContainerResourceAdaptor.DefaultDataSource;

/**
 * <p>
 * Titulo: HelpsResource.java
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
// @Stateless
@Path("/helps")
public class HelpsResource {

    @Inject
    HelpCDIService helpCDIService;

    @Inject
    HelpEJBService helpEJBService;

    @GET
    @Path("/ping")
    public String ping() {
        return helpEJBService.ping();
    }

    private static final int VALIDATION_TIMEOUT_IN_SECONDS = 30;

    @Inject
    @DefaultDataSource
    DataSource dataSource;

    @GET
    @Path("/ping/db")
    public String pingDB() {
        Boolean connected = false;
        try {
            connected = dataSource.getConnection().isValid(VALIDATION_TIMEOUT_IN_SECONDS);
        } catch (SQLException e) {
            connected = false;
        }
        return connected ? "Pong!" : "Sorry :(";
    }

    @Inject
    @WelcomeMessagePropertyValue
    String welcomeMessage;

    @GET
    @Path("/welcome")
    public String welcome() {
        return welcomeMessage;
    }
}
