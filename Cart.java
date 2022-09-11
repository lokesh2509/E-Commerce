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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pratik
 */
public class Cart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String p_name = request.getParameter("p_name");
        String p_qty = request.getParameter("p_qty");
        String p_price = request.getParameter("p_price");
        String btn = request.getParameter("Submit");

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ecommerce", "root", "root");
            PreparedStatement pst = con.prepareStatement("insert into Cart values(?,?,?)");
            pst.setString(1, p_name);
            pst.setString(2, p_qty);
            pst.setString(3, p_price);
            pst.executeUpdate();

        } catch (Exception e) {
            out.println(e);
        }

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ecommerce", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Cart");
            while (rs.next()) {
                String t1 = rs.getString(1);
                String t2 = rs.getString(2);
                String t3 = rs.getString(3);
                out.println("<!DOCTYPE html>\n"
                        + "<!--\n"
                        + "To change this license header, choose License Headers in Project Properties.\n"
                        + "To change this template file, choose Tools | Templates\n"
                        + "and open the template in the editor.\n"
                        + "-->\n"
                        + "<html>\n"
                        + "    <head>\n"
                        + "        <title>TODO supply a title</title>\n"
                        + "        <meta charset=\"UTF-8\">\n"
                        + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "    </head>\n"
                        + "    <body>\n"
                        + "        <table>\n"
                        + "            <tr>\n"
                        + "                <th>Product Name</th>\n"
                        + "                <th>Product Qty</th>\n"
                        + "                <th>Product Price</th>\n"
                        + "            </tr>\n"
                        + "            \n"
                        + "            <tr>\n"
                        + "                <td>" + t1 + "</td>\n"
                        + "                <td>" + t2 + "</td>\n"
                        + "                <td>" + t3 + "</td>\n"
                        + "            </tr>\n"
                        + "        </table>\n"
                        + "\n"
                        + "        <form method=get action=Buy>\n"
                        + "<input type=\"hidden\" name=\"pn\" value="+rs.getString(1)+">\n"
                        + "<input type=\"hidden\" name=\"pqty\" value="+rs.getString(2)+">\n"
                        + "<input type=\"hidden\" name=\"pprice\" value="+rs.getString(3)+">\n"
                        + "            <input type=\"submit\" name=\"Submit\" value=\"BUY\">\n"
                        + "        </form>"
                        + "    </body>\n"
                        + "</html>");
            }

        } catch (Exception ee) {
            out.println(ee);
        }
    }

}
