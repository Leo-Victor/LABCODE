package com.poly.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class I18nFilter implements Filter{
	@Override
    public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // Lấy giá trị lang từ URL (?lang=vi)
        String lang = req.getParameter("lang");
        if (lang != null) {
            req.getSession().setAttribute("lang", lang);
        }

        // Lấy lang hiện tại từ session (mặc định en)
        String current = (String) req.getSession().getAttribute("lang");
        if (current == null) {
            current = "en";
            req.getSession().setAttribute("lang", current);
        }

        // Gán cho cả request (để JSP đọc được)
        req.setAttribute("lang", current);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
