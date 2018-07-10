package com.mycompany.rest.server;

import com.mycompany.rest.server.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class ApplicationInitializer implements WebApplicationInitializer {

    private final static String DISPATHCER  = "dispatcher";
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATHCER, new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);

    }
}
