package com.crown.vue.servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ClassName ${NAME}
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/8/13
 * @Time 10:40
 * @Version 1.0
 */
@WebServlet(name = "Servlet",urlPatterns = {"/data"})
public class DataServlet1 extends HttpServlet {

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
        System.out.println("1111");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1-1");
        strings.add("1-2");
        strings.add("1-3");
        ArrayList<String> strings1 = new ArrayList<>();
        strings1.add("2-1");
        strings1.add("2-2");
        strings1.add("2-3");
        stringObjectHashMap.put("a",strings);
        stringObjectHashMap.put("b",strings1);
        Gson gson = new Gson();
        String str = gson.toJson(stringObjectHashMap);
        out.println(str);
        out.flush();
        out.close();

    }
}
