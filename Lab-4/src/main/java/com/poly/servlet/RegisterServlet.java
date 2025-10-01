package com.poly.servlet;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/account/register")
public class RegisterServlet extends HttpServlet{
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Đọc tham số đơn trị
        String fullname = req.getParameter("fullname");
        String gender = req.getParameter("gender"); // radio
        String country = req.getParameter("country");
        // Đọc tham số đa trị
        String[] hobbies = req.getParameterValues("hobby");

        // In ra console (server) để kiểm tra như yêu cầu
        System.out.println("Fullname: " + fullname);
        System.out.println("Gender: " + gender);
        System.out.println("Country: " + country);
        System.out.println("Hobbies: " + (hobbies == null ? "none" : Arrays.toString(hobbies)));

        // Forward lại trang với message
        req.setAttribute("message", "Đã nhận dữ liệu. Kiểm tra console server để xem chi tiết.");
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }
}
