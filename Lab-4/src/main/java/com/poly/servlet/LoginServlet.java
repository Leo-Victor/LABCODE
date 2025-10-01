package com.poly.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/account/Login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		req.setAttribute("message", "Enter username and password");
		req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(username.equalsIgnoreCase("FPT")&& password.equals("Poly"))	{
			req.setAttribute("message", "Login success");
		}else {
			req.setAttribute("message", "Invalid username or password");
		}
		req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
	}
}
