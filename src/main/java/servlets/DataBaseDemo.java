package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Вадим on 08.04.2017.
 */
@WebServlet(urlPatterns = "/DataBaseDemo")
public class DataBaseDemo extends HttpServlet {

    private static final String URL_BD = "jdbc:mysql://localhost:3306/developersDB?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String GET_ALL_DEVELOPERS_RECORDS = "SELECT * FROM developers";

    public Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(URL_BD, USER, PASSWORD);
        System.out.println("connection is good");
        return connection;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String title = "Database Demo";
        String docType = "<!DOCTYPE html>";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection is fault");
        }

        try (Connection connection = getConnection();
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(GET_ALL_DEVELOPERS_RECORDS);

                writer.println(docType + "<html><head><title>" + title + "</title></head><body>");
                writer.println("<h1>DEVELOPERS DATA</h1>");
                writer.println("<br/>");


                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String speciality = resultSet.getString("speciality");
                    int salary = resultSet.getInt("salary");

                    writer.println("ID: " + id);
                    writer.println("First name: " + name + "<br/>");
                    writer.println("Specialty: " + speciality + "<br/>");
                    writer.println("Salary: $" + salary + "<br/>");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        writer.println("</body></html>");

    }
}
