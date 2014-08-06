package by.azargan.application;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author Aliaksei_Vihuro
 */
@Slf4j
@Configurable
@ComponentScan(basePackages = "by.azargan.config")
public class ApplicationLauncher implements WebApplicationInitializer {

    private final String CONFIG_LOCATION = "by.azargan.config";
    private final String MAPPING_URL = "/*";

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        log.info("Start initialise application context");
        WebApplicationContext context = getContext(servletContext);
        servletContext.addListener(new ContextLoaderListener(context));

        log.info("Add dispatcher servlet");
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("DispatcherServlet",
                        new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(MAPPING_URL);
    }

    private AnnotationConfigWebApplicationContext getContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.setServletContext(servletContext);
        context.setConfigLocation(CONFIG_LOCATION);
        return context;
    }

    public static void main(String[] args) {

    }

}
