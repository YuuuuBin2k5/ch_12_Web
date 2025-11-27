package murach.sql;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "SqlGatewayServlet", urlPatterns = {"/sqlGateway"})
public class SqlGatewayServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String sqlStatement = request.getParameter("sqlStatement");
        String sqlResult = "";

        try (Connection conn = DBUtil.getConnection();
            Statement statement = conn.createStatement()) {

           if (sqlStatement != null && sqlStatement.length() >= 6) {
               String sqlType = sqlStatement.substring(0, 6);

               if (sqlType.equalsIgnoreCase("select")) {
                   try (ResultSet rs = statement.executeQuery(sqlStatement)) {
                       sqlResult = SQLUtil.getHtmlTable(rs);
                   }
               } else {
                   int i = statement.executeUpdate(sqlStatement);
                   sqlResult = "<p>The statement executed successfully.<br>" + i + " row(s) affected.</p>";
               }
           }

       } catch (SQLException e) {
           sqlResult = "<p>Error executing SQL:<br>" + e.getMessage() + "</p>";
       }


        HttpSession session = request.getSession();
        session.setAttribute("sqlResult", sqlResult);
        session.setAttribute("sqlStatement", sqlStatement);

        getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }
}
