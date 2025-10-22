package com.poly.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String path = req.getPathInfo(); // /index, /about, /contact
        String view;

        if (path == null || path.equals("/") || path.equals("/index")) {
            view = "/views/index.jsp";
        } else if (path.equals("/about")) {
            view = "/views/about.jsp";
        } else if (path.equals("/contact")) {
            view = "/views/contact.jsp";
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        req.setAttribute("view", view);
        req.getRequestDispatcher("/layout.jsp").forward(req, resp);
    }
}
