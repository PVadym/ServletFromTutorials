package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Вадим on 08.04.2017.
 */
@WebServlet(urlPatterns = "/RedirectDemo")
public class RedirectDemo extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        String docType = "<!DOCTYPE html>";
        String title = "Redirect Demo";
        String redirectionWebsite = "http://google.com/";
        PrintWriter writer = response.getWriter();

        writer.println(docType + "<html>" +
                "<head>" +
                "<title>" + title +
                "</title>" +
                "</head>" +
                "<body>" +
                "<h1>You will be redirected to http://proselyte.net/</h1>" +
                "</body>" +
                "</html>");

        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location", redirectionWebsite);
    }
}
