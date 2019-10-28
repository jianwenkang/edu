package com.crown.vue.servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @ClassName ${NAME}
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/8/13
 * @Time 10:40
 * @Version 1.0
 */
@WebServlet(name = "aServlet",urlPatterns = {"/sub"})
public class DataServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");
        service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get");
        service(req,resp);
    }

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(arg0.getParameterValues("name")[0]);
        System.out.println(arg0.getParameter("tsource"));
        System.out.println(arg0.getParameter("ssource"));
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String str ="{\"姓名\":\"HaHa先1生\",\"年龄\":\"18岁啦\"}";
        Gson gson = new Gson();
        HashMap<String, Object> map = new HashMap<>();
       // String str = gson.toJson(map);
        out.println(str);
        out.flush();
        out.close();
    }
}
