/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aarti
 */
public class Admin_Home_Page extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String url = request.getParameter("img");
        String name = request.getParameter("name_pro");
        String price = request.getParameter("price");
        String quantity = request.getParameter("Qty");
        String btn = request.getParameter("submit");

        if (btn.equals("Add")) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ecommerce", "root", "root");
                PreparedStatement pst = con.prepareStatement("insert into products values(?,?,?,?)");
                pst.setString(1, url);
                pst.setString(2, name);
                pst.setString(3, price);
                pst.setString(4, quantity);
                int row = pst.executeUpdate();

                RequestDispatcher rd = request.getRequestDispatcher("Admin_Home_Page.html");
                rd.forward(request, response);

            } catch (Exception e) {
                out.println(e);
            }
        }

    }
}
