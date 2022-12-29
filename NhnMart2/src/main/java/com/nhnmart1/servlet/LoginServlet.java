package com.nhnmart1.servlet;


import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "loginServlet", urlPatterns = "/login", initParams = {
    @WebInitParam(name = "id", value = "test"),
    @WebInitParam(name = "pwd", value = "1111")
})
@Slf4j
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String initParamId = getServletConfig().getInitParameter("id");
        String initParamPwd = getServletConfig().getInitParameter("pwd");

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        if (initParamId.equals(id) && initParamPwd.equals(pwd)) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);

            resp.sendRedirect("/login");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/login.html");
            rd.forward(req, resp);

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        resp.setCharacterEncoding("UTF-8");
        if (Objects.isNull(session)) {
            RequestDispatcher rd = req.getRequestDispatcher("/login.html");
            rd.forward(req, resp);

        } else {
            resp.setContentType("text/html");
            resp.getWriter().println("login success: id=" + session.getAttribute("id"));
            resp.getWriter().println("<br />");
            resp.getWriter().println("<a href='/logout'>logout</a>");
            resp.getWriter().println("<a href='/index.html'>마트입장!</a>");
        }
    }
}

