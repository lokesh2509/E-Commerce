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

public class Customer_Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String Name = request.getParameter("firstName");
        String Secondname = request.getParameter("secondName");
        String phone = request.getParameter("phoneNo");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("Gender");
        String next = request.getParameter("Submit");

        if (next.equals("SUBMIT")) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ecommerce", "root", "root");
                PreparedStatement pst = con.prepareStatement("insert into Customer values(?,?,?,?,?,?)");
                pst.setString(1, Name);
                pst.setString(2, Secondname);
                pst.setString(3, phone);
                pst.setString(4, email);
                pst.setString(5, password);
                pst.setString(6, gender);
                int row = pst.executeUpdate();
                out.println("<h1>" + row + "Values Inserted Succesfullyyyyy");

                RequestDispatcher rd = request.getRequestDispatcher("Customer_login.html");
                rd.forward(request, response);

            } catch (Exception e) {
                out.println(e);
            }
        } else {
            out.println("ERROR");
            RequestDispatcher rd = request.getRequestDispatcher("customer_registrationn.html");
            rd.include(request, response);
        }
    }

}
