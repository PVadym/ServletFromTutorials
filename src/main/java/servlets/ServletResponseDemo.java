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
@WebServlet(urlPatterns = "/ServletResponseDemo")
public class ServletResponseDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setHeader("hello","544");

        PrintWriter writer = response.getWriter();
        String title = "HTTP Servlet Response Demo";
        String docType = "<!DOCTYPE html>";

        writer.println(docType +
                "<html>\n" + "<head><title>" + title + "</title></head>\n" +
                "<body>" + response.getContentType() + "\n"+response.getHeader("hello")+"</body>");
    }
}
