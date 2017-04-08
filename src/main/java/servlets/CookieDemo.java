package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Вадим on 08.04.2017.
 */
@WebServlet(urlPatterns = "/CookieDemo")
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie sessionId = new Cookie("session_id", request.getSession().getId());
        Cookie language = new Cookie("language", request.getLocale().toString());
        response.addCookie(sessionId);
        response.addCookie(language);

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        String title = "Cookie Demo";

        Cookie[] cookies = request.getCookies();

        printWriter.println("<html><head><title>" + title + "</title></head><body>");

        if (cookies != null) {
            printWriter.println("Cookies");
            for (int i = 0; i < cookies.length; i++) {
                printWriter.println("<hr/>");
                printWriter.println("Name: " + cookies[i].getName());
                printWriter.println("<br/>");
                printWriter.println("Value: " + cookies[i].getValue());
                printWriter.println("<hr/>");
            }
        } else {
            printWriter.println("No cookies");
        }
        printWriter.println("</body></html>");

    }
}
