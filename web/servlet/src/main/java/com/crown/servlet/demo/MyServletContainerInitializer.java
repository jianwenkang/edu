package com.crown.servlet.demo;

import javax.servlet.*;
import java.util.EnumSet;
import java.util.Set;

/**
 * @ClassName CustomServletContainerInitializer
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/8
 * @Time 10:17
 * @Version 1.0
 */
public class MyServletContainerInitializer implements ServletContainerInitializer {

    private final static String JAR_HELLO_URL = "/hello";

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext servletContext) {

        System.out.println("创建 helloWorldServlet...");

        ServletRegistration.Dynamic servlet = servletContext.addServlet(
                HelloWorldServlet.class.getSimpleName(),
                HelloWorldServlet.class);
        servlet.addMapping(JAR_HELLO_URL);

        System.out.println("创建 helloWorldFilter...");

        FilterRegistration.Dynamic filter = servletContext.addFilter(
                HelloWorldFilter.class.getSimpleName(), HelloWorldFilter.class);

        EnumSet<DispatcherType> dispatcherTypes = EnumSet.allOf(DispatcherType.class);
        dispatcherTypes.add(DispatcherType.REQUEST);
        dispatcherTypes.add(DispatcherType.FORWARD);

        filter.addMappingForUrlPatterns(dispatcherTypes, true, JAR_HELLO_URL);

    }
}
