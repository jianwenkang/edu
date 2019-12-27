package com.crown.servlet.themeleaf;

import org.thymeleaf.TemplateEngine;

import javax.servlet.ServletContext;

/**
 * @ClassName themeleaf
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/7
 * @Time 11:44
 * @Version 1.0
 */
//@WebListener
public class TemplateEngineUtil {

    private static final String TEMPLATE_ENGINE_ATTR = "com.e-learn.thymeleaf3.TemplateEngineInstance";

    public static void storeTemplateEngine(ServletContext context, TemplateEngine engine) {
        context.setAttribute(TEMPLATE_ENGINE_ATTR, engine);
    }

    public static TemplateEngine getTemplateEngine(ServletContext context) {
        return (TemplateEngine) context.getAttribute(TEMPLATE_ENGINE_ATTR);
    }

}
