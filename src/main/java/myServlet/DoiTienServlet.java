/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSI_PC
 */
public class DoiTienServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String loaiNgoaiTe = request.getParameter("loaingoaite");
        double soTienQuyNgoaiTe = Double.parseDouble(request.getParameter("sotien"));
        double tienViet = 0;
        switch (loaiNgoaiTe) {
            case "USD":
                tienViet = soTienQuyNgoaiTe * 21380.00;
                break;
            case "GBP":
                tienViet = soTienQuyNgoaiTe * 32622.80;
                break;
            case "EUR":
                tienViet = soTienQuyNgoaiTe * 23555.67;
                break;
            case "JPY":
                tienViet = soTienQuyNgoaiTe * 178.61;
                break;
            case "AUD":
                tienViet = soTienQuyNgoaiTe * 16727.44;
                break;
            default:
                throw new AssertionError();
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DoiTienServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Xử lý đổi tiền từ ngoại tệ ra tiền việt</h3><hr>");
            out.println("<p>" +decimalFormat.format(soTienQuyNgoaiTe) + " " +loaiNgoaiTe + " = " +decimalFormat.format(tienViet) + " VND"  +"</p>");
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
    }

}
