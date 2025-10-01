package com.poly.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/calculate/add", "/calculate/sub"})
public class CalculateServlet extends HttpServlet{
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        req.setAttribute("message", "Nhập số và chọn phép tính");
	        req.getRequestDispatcher("/calculate.jsp").forward(req, resp);
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        String a = req.getParameter("a");
	        String b = req.getParameter("b");
	        String path = req.getServletPath();
	        String message;

	        double da = 0, db = 0;
	        boolean ok = true;
	        try {
	            da = Double.parseDouble(a != null ? a.trim() : "0");
	            db = Double.parseDouble(b != null ? b.trim() : "0");
	        } catch (NumberFormatException e) {
	            ok = false;
	        }

	        if (!ok) {
	            message = "Vui lòng nhập 2 số hợp lệ.";
	        } else if (path.endsWith("/add")) {
	            double c = da + db;
	            message = a + " + " + b + " = " + c;
	        } else {
	            double c = da - db;
	            message = a + " - " + b + " = " + c;
	        }

	        req.setAttribute("message", message);
	        req.getRequestDispatcher("/calculate.jsp").forward(req, resp);
	    }
}
