package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validation_servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("Name");
        String password = request.getParameter("password");
        String button = request.getParameter("Submit");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ecommerce", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select * from Customer");
            while (res.next()) {
                String userName = res.getString(1);
                String pass = res.getString(5);

                if (name.equals(userName) && password.equals(pass)) {
                    response.sendRedirect("http://localhost:8080/Varience/Customer_page");
                } else {
                    out.println("Invalid Credentials");
                    RequestDispatcher rd = request.getRequestDispatcher("/Customer_login.html");
                    rd.include(request, response);
                    break;
                }
            }

        } catch (Exception e) {
            out.println(e);
        }

    }
}
