/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author MSI_PC
 */
@MultipartConfig
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String hoTen = request.getParameter("hoten");
        String gioiTinh = request.getParameter("gioitinh");
        String[] soThich = request.getParameterValues("sothich");
        Part part = request.getPart("anhdaidien");
        
        String realPath = request.getServletContext().getRealPath("/uploads");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        part.write(realPath + "/" + filename); 

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>THÔNG TIN ĐÃ ĐĂNG KÝ</h2><hr>");
            out.println("<ul>");
            out.println("<li>Họ tên: <b>" +hoTen + "</b></li>");
            out.println("<li>Giới tính: <b>" +gioiTinh + "</b></li>");
            out.println("<li>Sở thích: <b>" +Arrays.toString(soThich) + "</b></li>");
            out.println("<li>Ảnh đại diện <br> <img src='uploads/"+ filename + "' width=200px></li>");
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}