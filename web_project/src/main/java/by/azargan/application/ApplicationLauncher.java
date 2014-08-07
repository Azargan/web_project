package by.azargan.application;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author Aliaksei_Vihuro
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = "by.azargan.config")
public class ApplicationLauncher implements WebApplicationInitializer {

    private final String CONFIG_LOCATION = "by.azargan.config";
    private final String MAPPING_URL = "/*";

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.setConfigLocation(CONFIG_LOCATION);
        servletContext.addListener(new ContextLoaderListener(appContext));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(MAPPING_URL);
        appContext.setServletContext(servletContext);
        appContext.refresh();
    }

    public static void main(String[] args) {

    }

}
