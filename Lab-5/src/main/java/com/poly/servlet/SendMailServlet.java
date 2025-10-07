package com.poly.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/send-mail")
public class SendMailServlet extends HttpServlet{
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
        req.getRequestDispatcher("/views/mail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String from = req.getParameter("from");
        String to = req.getParameter("to");
        String subject = req.getParameter("subject");
        String body = req.getParameter("body");

        String smtpUser = getServletContext().getInitParameter("smtpUser");
        String smtpPass = getServletContext().getInitParameter("smtpPass");

        try {
            Mailer.send(from, to, subject, body, smtpUser, smtpPass);
            req.setAttribute("message", "Email đã gửi thành công.");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "Gửi mail thất bại: " + e.getMessage());
        }
        req.getRequestDispatcher("/views/mail-result.jsp").forward(req, resp);
    }
}
