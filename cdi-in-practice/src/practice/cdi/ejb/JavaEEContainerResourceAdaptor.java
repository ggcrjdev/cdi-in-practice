package practice.cdi.ejb;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.inject.Qualifier;
import javax.sql.DataSource;
import javax.xml.ws.WebServiceRef;

import practice.cdi.jaxws.HelpSoap;

/**
 * <p>
 * Titulo: JavaeeResourceAdaptor.java
 * </p>
 * <p>
 * Descrição:
 * </p>
 * <br>
 * <b>Company:</b> FINEP - Projfin 30 Dias
 * 
 * @date 12/04/2016
 * @autor gustavo.conceicao
 * 
 */
@Singleton
public class JavaEEContainerResourceAdaptor {

    @Qualifier
    @Target({ TYPE, METHOD, PARAMETER, FIELD })
    @Retention(RUNTIME)
    public @interface DefaultDataSource {
    }

    @Produces
    @WebServiceRef(lookup = "java:app/poc-web-service/HelpSoap")
    static HelpSoap helpSoap;

    @Produces
    @Resource(lookup = "java:jboss/datasources/ExampleDS")
    @DefaultDataSource
    static DataSource defaultDS;

    // @Produces
    // @PersistenceContext(unitName = "DefaultPU")
    // @DefaultDataSource
    // EntityManager defaultEntityManager;
    //
    // @Produces
    // @PersistenceUnit(unitName = "DefaultPU")
    // @DefaultDataSource
    // EntityManagerFactory defaultEntityManagerFactory;

    @PostConstruct
    public void init() {
        System.out.println("Initialized resources to be injected by CDI.");
    }
}
