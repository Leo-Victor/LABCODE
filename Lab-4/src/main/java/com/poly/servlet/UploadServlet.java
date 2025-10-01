package com.poly.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Part filePart = req.getPart("photo");
        String message;
        if (filePart == null || filePart.getSize() == 0) {
            message = "Bạn chưa chọn file để upload.";
        } else {
            // Lấy tên file
            String submitted = filePart.getSubmittedFileName();
            // Thư mục lưu: /static/file trong webapp
            String real = req.getServletContext().getRealPath("/static/file");
            File uploadDir = new File(real);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            // Lưu file
            File saved = new File(uploadDir, submitted);
            try (InputStream in = filePart.getInputStream();
                 FileOutputStream fos = new FileOutputStream(saved)) {
                byte[] buffer = new byte[8192];
                int len;
                while ((len = in.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
            }
            message = "Upload thành công: " + submitted + " -> " + "/static/file/" + submitted;
        }
        req.setAttribute("message", message);
        req.getRequestDispatcher("/upload.jsp").forward(req, resp);
    }
}
