package com.crown.servlet.themeleaf;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName IndexServlet
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/7
 * @Time 11:47
 * @Version 1.0
 */
//@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        response.setCharacterEncoding("utf-8");
        context.setVariable("recipient", "e-learn");
        engine.process("index.html", context, response.getWriter());
    }

}
