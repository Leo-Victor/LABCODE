package com.poly.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("user".equals(c.getName())) {
                    String encoded = c.getValue();
                    byte[] bytes = Base64.getDecoder().decode(encoded);
                    String[] userInfo = new String(bytes, StandardCharsets.UTF_8).split(",");
                    if (userInfo.length >= 2) {
                        req.setAttribute("username", userInfo[0]);
                        req.setAttribute("password", userInfo[1]);
                    }
                }
            }
        }
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember-me");

        if ("FPT".equalsIgnoreCase(username) && "poly".equals(password)) {
            req.setAttribute("message", "Login successfully!");
            req.getSession().setAttribute("username", username);

            if (remember != null) {
                String combined = username + "," + password;
                String encoded = Base64.getEncoder().encodeToString(combined.getBytes(StandardCharsets.UTF_8));
                Cookie cookie = new Cookie("user", encoded);
                cookie.setMaxAge(30 * 24 * 60 * 60); // 30 days
                cookie.setPath(req.getContextPath().isEmpty() ? "/" : req.getContextPath());
                resp.addCookie(cookie);
            }
        } else {
            req.setAttribute("message", "Invalid login info!");
        }
        req.getRequestDispatcher("/views/login-result.jsp").forward(req, resp);
    }
}
