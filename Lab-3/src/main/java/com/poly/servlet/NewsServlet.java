package com.poly.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/news")
public class NewsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		Map<String, Object> map = new HashMap<>();
		map.put("title", "Tiêu đề bản tin");
        map.put("content", "Nội dung bản tin thường rất dài và có thể vượt quá 100 ký tự, "
                + "chúng ta sẽ cắt chuỗi để hiển thị ngắn gọn hơn trong trang JSP.");
        req.setAttribute("item", map);

        req.getRequestDispatcher("/views/news.jsp").forward(req, resp);
	}
}
