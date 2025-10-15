package com.poly.servlet;

import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.DepartmentDao;
import com.poly.dao.DepartmentDaoImpl;
import com.poly.entity.Department;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import com.poly.entity.Department;

@WebServlet({
    "/",
    "/department/edit/*",
    "/department/create",
    "/department/update",
    "/department/delete",
    "/department/reset"
})
public class DepartmentServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Department form = new Department();
    try {
        BeanUtils.populate(form, req.getParameterMap());
    } catch (IllegalAccessException | InvocationTargetException e) {
        throw new ServletException(e);
    }

    DepartmentDao dao = new DepartmentDaoImpl();
    String path = req.getServletPath();

    if (path.contains("edit")) {
        String id = req.getPathInfo(); // /{id}
        if (id != null && id.length() > 1) {
            id = id.substring(1);
            form = dao.findById(id);
        }
    } else if (path.contains("create")) {
        dao.create(form);
        form = new Department();
    } else if (path.contains("update")) {
        dao.update(form);
    } else if (path.contains("delete")) {
        dao.deleteById(form.getId());
        form = new Department();
    } else { // index or reset
        form = new Department();
    }

    req.setAttribute("item", form);
    List<Department> list = dao.findAll();
    req.setAttribute("list", list);
    req.getRequestDispatcher("/views/Department.jsp").forward(req, resp);
}
}
