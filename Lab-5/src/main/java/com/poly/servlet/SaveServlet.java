package com.poly.servlet;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.OnError;

@WebServlet("/save")
public class SaveServlet extends HttpServlet{
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/views/Staff.jsp").forward(req, resp);
    }
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		Staff bean = new Staff(); // dùng để chứa dữ liệu form
		try {
		// Khai báo định dạng ngày
		DateTimeConverter dtc = new DateConverter(new Date());
		dtc.setPattern("MM/dd/yyyy");
		ConvertUtils.register(dtc, Date.class);
		// đọc và chuyển đổi tham số vào bean
		BeanUtils.populate(bean, req.getParameterMap());
		System.out.println(bean.getFullname());
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}

