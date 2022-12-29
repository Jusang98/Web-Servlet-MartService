package com.nhnmart1.servlet;


import com.nhnmart1.domain.Food;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "foodsServlet", urlPatterns = "/foods")
public class FoodsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        ServletContext servletContext = getServletContext();
        PrintWriter out = resp.getWriter();
        ArrayList<Food> foods = (ArrayList<Food>) servletContext.getAttribute("foods");


        out.println("<form method=\"post\" action=\"/cart\">");
        for (int i = 0; i < foods.size(); i++) {

            out.println(foods.get(i).getName() + foods.get(i).getPrice()
                + "<input type=\"checkbox\" name=\"items\" value=" + foods.get(i).getName() + ">" +
                "<br/>");
        }
        out.println("<input type=\"submit\" value=\"장바구니\">");
        out.println("</form>");


    }
}
