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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aarti
 */
public class Customer_page extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                + "        <style>\n" + "\n" + "*{\n"
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
                + "                color: white;}"
                + "\n"
                + "\n"
                + "            .column {\n"
                + "                float: left;\n"
                + "                width: 25%;\n"
                + "                padding: 0 10px;\n"
                + "            }\n"
                + "\n"
                + "            /* Remove extra left and right margins, due to padding */\n"
                + "            .row {margin: 0 -5px;}\n"
                + "\n"
                + "            /* Clear floats after the columns */\n"
                + "            .row:after {\n"
                + "                content: \"\";\n"
                + "                display: table;\n"
                + "                clear: both;\n"
                + "            }\n"
                + "\n"
                + "            /* Responsive columns */\n"
                + "            @media screen and (max-width: 600px) {\n"
                + "                .column {\n"
                + "                    width: 100%;\n"
                + "                    display: block;\n"
                + "                    margin-bottom: 20px;\n"
                + "                }\n"
                + "            }\n"
                + "\n"
                + "            /* Style the counter cards */\n"
                + "            .card {\n"
                + "                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);\n"
                + "                padding: 16px;\n"
                + "                text-align: center;\n"
                + "                background-color: #f1f1f1;\n"
                + "            }\n"
                + "            * {box-sizing: border-box}\n"
                + "            body {font-family: Verdana, sans-serif; margin:0}\n"
                + "            .mySlides {display: none}\n"
                + "            i???\n"
                + "            [8:58 PM, 9/7/2022] Jinal Gujar: <!DOCTYPE html>\n"
                + "            <html>\n"
                + "            <head>\n"
                + "            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                + "            <style>\n"
                + "\n"
                + "\n"
                + "            .column {\n"
                + "                float: left;\n"
                + "                width: 25%;\n"
                + "                padding: 0 10px;\n"
                + "            }\n"
                + "\n"
                + "            /* Remove extra left and right margins, due to padding */\n"
                + "            .row {margin: 0 -5px;}\n"
                + "\n"
                + "            /* Clear floats after the columns */\n"
                + "            .row:after {\n"
                + "                content: \"\";\n"
                + "                display: table;\n"
                + "                clear: both;\n"
                + "            }\n"
                + "\n"
                + "            /* Responsive columns */\n"
                + "            @media screen and (max-width: 600px) {\n"
                + "                .column {\n"
                + "                    width: 100%;\n"
                + "                    display: block;\n"
                + "                    margin-bottom: 20px;\n"
                + "                }\n"
                + "            }\n"
                + "\n"
                + "            /* Style the counter cards */\n"
                + "            .card {\n"
                + "                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);\n"
                + "                padding: 16px;\n"
                + "                text-align: center;\n"
                + "                background-color: #f1f1f1;\n"
                + "            }\n"
                + "            * {box-sizing: border-box}\n"
                + "            body {font-family: Verdana, sans-serif; margin:0}\n"
                + "            .mySlides {display: none}\n"
                + "            img {vertical-align: middle;}\n"
                + "\n"
                + "            /* Slideshow container */\n"
                + "            .slideshow-container {\n"
                + "                max-width: 1000px;\n"
                + "                position: relative;\n"
                + "                margin: auto;\n"
                + "            }\n"
                + "\n"
                + "            /* Next & previous buttons */\n"
                + "            .prev, .next {\n"
                + "                cursor: pointer;\n"
                + "                position: absolute;\n"
                + "                top: 50%;\n"
                + "                width: auto;\n"
                + "                padding: 16px;\n"
                + "                margin-top: -22px;\n"
                + "                color: white;\n"
                + "                font-weight: bold;\n"
                + "                font-size: 18px;\n"
                + "                transition: 0.6s ease;\n"
                + "                border-radius: 0 3px 3px 0;\n"
                + "                user-select: none;\n"
                + "            }\n"
                + "\n"
                + "            /* Position the \"next button\" to the right */\n"
                + "            .next {\n"
                + "                right: 0;\n"
                + "                border-radius: 3px 0 0 3px;\n"
                + "            }\n"
                + "\n"
                + "            /* On hover, add a black background color with a little bit see-through */\n"
                + "            .prev:hover, .next:hover {\n"
                + "                background-color: rgba(0,0,0,0.8);\n"
                + "            }\n"
                + "\n"
                + "            /* Caption text */\n"
                + "            .text {\n"
                + "                color: #f2f2f2;\n"
                + "                font-size: 15px;\n"
                + "                padding: 8px 12px;\n"
                + "                position: absolute;\n"
                + "                bottom: 8px;\n"
                + "                width: 100%;\n"
                + "                text-align: center;\n"
                + "            }\n"
                + "\n"
                + "            /* Number text (1/3 etc) */\n"
                + "            .numbertext {\n"
                + "                color: #f2f2f2;\n"
                + "                font-size: 12px;\n"
                + "                padding: 8px 12px;\n"
                + "                position: absolute;\n"
                + "                top: 0;\n"
                + "            }\n"
                + "\n"
                + "            /* The dots/bullets/indicators */\n"
                + "            .dot {\n"
                + "                cursor: pointer;\n"
                + "                height: 15px;\n"
                + "                width: 15px;\n"
                + "                margin: 0 2px;\n"
                + "                background-color: #bbb;\n"
                + "                border-radius: 50%;\n"
                + "                display: inline-block;\n"
                + "                transition: background-color 0.6s ease;\n"
                + "            }\n"
                + "\n"
                + "            .active, .dot:hover {\n"
                + "                background-color: #717171;\n"
                + "            }\n"
                + "\n"
                + "            /* Fading animation */\n"
                + "            .fade {\n"
                + "                animation-name: fade;\n"
                + "                animation-duration: 1.5s;\n"
                + "            }\n"
                + "\n"
                + "            @keyframes fade {\n"
                + "                from {opacity: .4} \n"
                + "                to {opacity: 1}\n"
                + "            }\n"
                + "\n"
                + "            /* On smaller screens, decrease text size */\n"
                + "            @media only screen and (max-width: 300px) {\n"
                + "                .prev, .next,.text {font-size: 11px}\n"
                + "            }\n"
                + "        </style>\n"
                + "    </head>\n"
                + "    <body>\n" + " <!-- Nav -->\n"
                + "        <div class=\"topnav\">\n"
                + "            <a href=\"About_US.html\">About Us</a>\n"
                + "            <a href=\"Admin_login.html\">Admin Login</a>\n"
                + "            <a href=\"Customer_login.html\">Sign In</a>\n"
                + "            <a href=\"customer_registration.html\">Sign Up</a>\n"
                + "            <a href=\"Home_Page.html\">Home</a>\n"
                + "            <h3 id=\"logo\" style=\"font-size: 30px\">VARIENCE</h3>\n"
                + "        </div>"
                + "\n"
                + "        <div class=\"slideshow-container\">\n"
                + "\n"
                + "            <div class=\"mySlides fade\">\n"
                + "                <img src=\"https://thumbs.dreamstime.com/b/collage-five-beautiful-models-colored-summer-dresses-outdoors-street-fashion-64982373.jpg\" style=\"width:100%\">\n"
                + "            </div>\n"
                + "\n"
                + "            <div class=\"mySlides fade\">\n"
                + "                <img src=\"https://www.loreperfumery.com.au/wp-content/uploads/2021/03/Lore_a4poster_goldfieldbanks.jpg\" style=\"width:100%\">\n"
                + "            </div>\n"
                + "\n"
                + "            <div class=\"mySlides fade\">\n"
                + "                <img src=\"https://thumbs.dreamstime.com/b/jewels-collage-beautiful-young-woman-jewelry-earrings-stylish-accessories-girls-251088302.jpg\" style=\"width:100%\">\n"
                + "            </div>\n"
                + "\n"
                + "            <a class=\"prev\" onclick=\"plusSlides( - 1)\"><i class=\"arrow right\"></i></a>\n"
                + "            <a class=\"next\" onclick=\"plusSlides(1)\"></a>\n"
                + "\n"
                + "        </div>\n"
                + "        <br>\n"
                + "");
        out.println("<div style=\"text-align:center\">\n"
                + "            <span class=\"dot\" onclick=\"currentSlide(1)\"></span> \n"
                + "            <span class=\"dot\" onclick=\"currentSlide(2)\"></span> \n"
                + "            <span class=\"dot\" onclick=\"currentSlide(3)\"></span> \n"
                + "        </div>\n"
                + "\n"
        );
        out.println("<div class=\"row\">");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ecommerce", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from products");
            while (rs.next()) {
                out.println("  <div class=\"column\">\n"
                        + "    <div class=\"card\">\n"
                        + "      <h3>" + rs.getString(2) + "</h3>\n"
                        + "      <img src=" + rs.getString(1) + " width=\"100\" height=\"100\">\n"
                        + "      <p> Quantity: " + rs.getString(4) + "</p>\n"
                        + "      <p>Price:" + rs.getString(3) + "</p>\n"
                        + " <form method=get action=Cart> "
                        + "\n"
                        + "                    <input type=\"hidden\" name=\"p_name\" value="+rs.getString(2)+">\n"
                        + "                    <input type=\"hidden\" name=\"p_qty\" value="+rs.getString(4)+">\n"
                        + "                    <input type=\"hidden\" name=\"p_price\" value="+rs.getString(3)+">"
                        + "                    <input type=\"submit\" name=\"Submit\" value=\"ADD TO CART\">"
                        + "</form> "
                        + "    </div>\n"
                        + "  </div>");
            }

        } catch (Exception e) {
            out.println(e);
        }

        out.println(
                "        <script>\n"
                + "                    let slideIndex = 1;\n"
                + "                    showSlides(slideIndex);\n"
                + "                    function plusSlides(n) {\n"
                + "                    showSlides(slideIndex += n);\n"
                + "                    }\n"
                + "\n"
                + "            function currentSlide(n) {\n"
                + "            showSlides(slideIndex = n);\n"
                + "            }\n"
                + "\n"
                + "            function showSlides(n) {\n"
                + "            let i;\n"
                + "                    let slides = document.getElementsByClassName(\"mySlides\");\n"
                + "                    let dots = document.getElementsByClassName(\"dot\");\n"
                + "                    if (n > slides.length) {slideIndex = 1}\n"
                + "            if (n < 1) {slideIndex = slides.length}\n"
                + "            for (i = 0; i < slides.length; i++) {\n"
                + "            slides[i].style.display = \"none\";\n"
                + "            }\n"
                + "            for (i = 0; i < dots.length; i++) {\n"
                + "            dots[i].className = dots[i].className.replace(\" active\", \"\");\n"
                + "            }\n"
                + "            slides[slideIndex - 1].style.display = \"block\";\n"
                + "                    dots[slideIndex - 1].className += \" active\";\n"
                + "            }\n"
                + "        </script>\n"
                + "\n"
                + "    </body>\n"
                + "</html>");

    }

}
