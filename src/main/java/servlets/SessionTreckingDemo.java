package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Вадим on 08.04.2017.
 */
@WebServlet(urlPatterns = "/SessionTreckingDemo")
public class SessionTreckingDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String message = "";

        String sessionId = session.getId();
        Date dateOfCreation = new Date(session.getCreationTime());
        Date lastAccess = new Date(session.getLastAccessedTime());
        String userId = "userId";

        if (session.isNew()) {
            message = "Welcome to this page";
        } else {
            message = "Glad to see You again";
        }

        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        String title = "Session Tracking Demo";
        String docType = "<!DOCTYPE html>";

        writer.println(docType + "<html>" +
                "<head>" +
                "<title>" + title +
                "</title>" +
                "</head>" +
                "<body>" + message+
                "<h1>Session Details</h1>" +
                "Session ID:" + sessionId +
                "<br/>" +
                "Created: " + dateOfCreation +
                "<br/>" +
                "Last Accessed Date: " + lastAccess +
                "<br/>" +
                "User ID: " + userId +
                "</body>" +
                "</html>");
    }
}
