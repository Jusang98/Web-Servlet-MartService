package com.nhnmart1;


import javax.servlet.annotation.WebServlet;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class Start extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.error("service() called");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        log.error("destroy() called");
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.error("init() called");
        super.init(config);
    }

}

