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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pratik
 */
public class Buy extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String pn = request.getParameter("pn");
        String pqty = request.getParameter("pqty");
        String pprice = request.getParameter("pprice");
        String btn = request.getParameter("Submit");

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
                + "<style>\n"
                + "\n"
                + "            *{\n"
                + "                padding: 0;\n"
                + "                margin: 0;\n"
                + "            }\n"
                + "            body{\n"
                + "                background: url(http://wrbbradio.org/wp-content/uploads/2016/10/grey-background-07.jpg) no-repeat center fixed;\n"
                + "                background-size: cover;\n"
                + "            }\n"
                + "            /* Nav */\n"
                + "            .topnav {\n"
                + "                overflow: hidden;\n"
                + "                background-color: rgb(13, 9, 33);\n"
                + "            }\n"
                + "\n"
                + "            .topnav h3 {\n"
                + "                float: left;\n"
                + "                color: #f2f2f2;\n"
                + "                text-align: center;\n"
                + "                padding: 8px 150px;\n"
                + "                text-decoration: none;\n"
                + "                font-size: 10px;\n"
                + "            }\n"
                + "\n"
                + "            .topnav a {\n"
                + "                float: right;\n"
                + "                color: #f2f2f2;\n"
                + "                text-align: center;\n"
                + "                padding: 20px 16px;\n"
                + "                text-decoration: none;\n"
                + "                font-size: 17px;\n"
                + "            }\n"
                + "\n"
                + "            .topnav a:hover {\n"
                + "                border: 1px white solid;\n"
                + "            }\n"
                + "\n"
                + "            .topnav a.active {\n"
                + "                background-color: rgb(25, 16, 70);\n"
                + "                border: rgb(13, 9, 33);\n"
                + "                color: white;}\n"
                + "\n"
                + "            /*Main Body*/\n"
                + "            .container{\n"
                + "                background: #FA8072;\n"
                + "                width: 350px;\n"
                + "                height: 200px;\n"
                + "                padding-bottom: 20px;\n"
                + "                position: absolute;\n"
                + "                top:50%;\n"
                + "                left: 50%;\n"
                + "                transform: translate(-50%, -50%);\n"
                + "                margin: auto;\n"
                + "                padding: 70px 50px 20px 50px;\n"
                + "            }\n"
                + "\n"
                + "\n"
                + "            .fl{\n"
                + "                float: left;\n"
                + "                width: 110px;\n"
                + "                line-height: 35px;\n"
                + "            }\n"
                + "\n"
                + "            .fontLabel{\n"
                + "                color: white;\n"
                + "            }\n"
                + "\n"
                + "            .fr{\n"
                + "                float: right;\n"
                + "            }\n"
                + "\n"
                + "            .clr{\n"
                + "                clear: both;\n"
                + "            }\n"
                + "\n"
                + "            .box{\n"
                + "                width: 360px;\n"
                + "                height: 35px;\n"
                + "                margin-top: 10px;\n"
                + "                font-family: verdana;\n"
                + "                font-size: 12px;\n"
                + "            }\n"
                + "\n"
                + "            .textBox{\n"
                + "                height: 35px;\n"
                + "                width: 190px;\n"
                + "                border: none;\n"
                + "                padding-left: 20px;\n"
                + "            }\n"
                + "\n"
                + "            .new{\n"
                + "                float: left;\n"
                + "            }\n"
                + "\n"
                + "            .iconBox{\n"
                + "                height: 35px;\n"
                + "                width: 40px;\n"
                + "                line-height: 38px;\n"
                + "                text-align: center;\n"
                + "                background: #ff6600;\n"
                + "            }\n"
                + "\n"
                + "            .radio{\n"
                + "                color: white;\n"
                + "                background: #2d3e3f;\n"
                + "                line-height: 38px;\n"
                + "            }\n"
                + "\n"
                + "            .terms{\n"
                + "                line-height: 35px;\n"
                + "                text-align: center;\n"
                + "                background: #2d3e3f;\n"
                + "                color: white;\n"
                + "            }\n"
                + "\n"
                + "            .submit{\n"
                + "                float: right;\n"
                + "                border: none;\n"
                + "                color: white;\n"
                + "                width: 110px;\n"
                + "                height: 35px;\n"
                + "                background: #000000;\n"
                + "                text-transform: uppercase;\n"
                + "                cursor: pointer;\n"
                + "            }\n"
                + "\n"
                + "            ::-webkit-input-placeholder { \n"
                + "\n"
                + "            }\n"
                + "        </style>  "
                + "    </head>\n"
                + "    <body>\n"
                + "<!-- Nav -->\n"
                + "        <div class=\"topnav\">\n"
                + "            <a href=\"About_US.html\">About Us</a>\n"
                + "            <a href=\"Admin_login.html\">Admin Login</a>\n"
                + "            <a class=\"active\" href=\"Customer_login.html\">Sign In</a>\n"
                + "            <a href=\"customer_registration.html\">Sign Up</a>\n"
                + "            <a href=\"Home_Page.html\">Home</a>\n"
                + "            <h3 id=\"logo\" style=\"font-size: 30px\">VARIENCE</h3>\n"
                + "        </div>\n"
                + "\n"
                + "        <!--main body-->\n"
                + "        <div class=\"container\">\n"
                + "            <h1><center> Customer Buy Page</center></h1>\n"
                + "            Name of Product: "+ pn + "<br>"
                + "            Quantity of Product: "+ pqty + "<br>"
                + "            Price of Product: "+ pprice + "<br>"
                + "        </div>"
                + "    </body>\n"
                + "</html>");

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ecommerce", "root", "root");
            PreparedStatement pst = con.prepareStatement("TRUNCATE TABLE  Cart");
            pst.executeUpdate();

        } catch (Exception e) {
            out.println(e);
        }

    }
}
