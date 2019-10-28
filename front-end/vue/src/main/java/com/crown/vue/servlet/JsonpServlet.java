package com.crown.vue.servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;

/**
 * @ClassName ${NAME}
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/8/13
 * @Time 10:40
 * @Version 1.0
 */
@WebServlet(name = "jsonpServlet",urlPatterns = {"/jsonp"})
public class JsonpServlet extends HttpServlet {

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
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("url"));
        String ck = request.getParameter("ck");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","haha");
        map.put("id",1);
        map.put("time", new Date());
        String str = gson.toJson(map);
        String result = ck + "(" + str + ")";
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();

    }
}
