package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Вадим on 08.04.2017.
 */
@WebServlet(urlPatterns = "/AutoRefreshDemo")
public class AutoRefreshDemo extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setIntHeader("Refresh", 1);

        response.setContentType("text/html");

        Date currentDateTime = new Date();

        String docType = "<!DOCTYPE html>";
        String title = "Auto Refresh Demo";

        PrintWriter writer = response.getWriter();

        writer.println(docType + "<html>" +
                "<head>" +
                "<title>" + title +
                "</title>" +
                "</head>" +
                "<body>" +
                "<h1>Current date and time: </h1>" +
                currentDateTime.toString() +
                "</body>" +
                "</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
