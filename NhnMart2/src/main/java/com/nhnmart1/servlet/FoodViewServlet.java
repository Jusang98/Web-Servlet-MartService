package com.nhnmart1.servlet;


import com.nhnmart1.domain.Food;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FoodViewServlet implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        ArrayList<Food> foods = (ArrayList<Food>) servletContext.getAttribute("foods");
        servletContext.setAttribute("foods", foods);
//        ServletContext servletContext = req.getServletContext();
//        ArrayList<Food> foods = (ArrayList<Food>) servletContext.getAttribute("foods");
       return "/foodView.jsp";
    }
}
