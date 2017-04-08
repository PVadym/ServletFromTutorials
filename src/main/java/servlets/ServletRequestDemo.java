package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Вадим on 08.04.2017.
 */
@WebServlet(urlPatterns = "/ServletRequestDemo")
public class ServletRequestDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter= resp.getWriter();
        String title = "HTTP Request Example";
        String contentType = "<!DOCTYPE html>\n";
        printWriter.println(contentType + "<html>\n" +
                "<head><title>" + title + "</title></head>" +
                "<body>" +
                "<h1>HTTP Servlet Request Example </h1>"
        );

        Enumeration headers = req.getHeaderNames();
        while (headers.hasMoreElements()){
            String paramName = (String) headers.nextElement();
            String paranValue = req.getHeader(paramName);
            printWriter.println("<h3>" + paramName + " : " + paranValue + "</h3>");
        }
        printWriter.println("</body>" + "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
