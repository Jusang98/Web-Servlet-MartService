package com.nhnmart1.servlet;

import com.nhnmart1.domain.Food;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "foodStandServlet", urlPatterns = "/mart/init")
public class FoodStandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        ServletContext servletContext = getServletContext();
        PrintWriter out = resp.getWriter();
        int onion = Integer.parseInt(servletContext.getInitParameter("양파"));
        int egg = Integer.parseInt(servletContext.getInitParameter("계란"));
        int leek = Integer.parseInt(servletContext.getInitParameter("파"));
        int apple = Integer.parseInt(servletContext.getInitParameter("사과"));

        ArrayList<Food> foods = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            foods.add(new Food("양파", onion));
        }
        for (int i = 0; i < 5; i++) {
            foods.add(new Food("계란", egg));
        }
        for (int i = 0; i < 10; i++) {
            foods.add(new Food("파", leek));
        }
        for (int i = 0; i < 20; i++) {
            foods.add(new Food("사과", apple));
        }
        servletContext.setAttribute("foods", foods);
        out.println("준비완료");
        out.println("<br><a href='/foodstand.jsp'>상품 목록</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        doGet(req,resp);
    }
}
