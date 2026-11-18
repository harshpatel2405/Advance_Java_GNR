package feedbackSystem;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchFeedbackServlet")

public class SearchFeedbackServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static String url = "jdbc:mysql://localhost:3306/jdbc_demo";
    private static String username = "root";
    private static String password = "root123";

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connection Created Successfully");

            // Get values from HTML form
            String StudentName = req.getParameter("studentName");
            String courseName = req.getParameter("courseName");

            // Handle empty values
            StudentName = (StudentName == null) ? "" : StudentName.trim();
            courseName = (courseName == null) ? "" : courseName.trim();

            String Query;

            // Both fields are empty
            if (StudentName.isEmpty() && courseName.isEmpty()) {

                Query = "SELECT * FROM feedback";

            }

            // Search by Student Name
            else if (!StudentName.isEmpty() && courseName.isEmpty()) {

                Query = "SELECT * FROM feedback WHERE studentname LIKE '%"
                        + StudentName + "%'";

            }

            // Search by Course Name
            else if (StudentName.isEmpty() && !courseName.isEmpty()) {

                Query = "SELECT * FROM feedback WHERE coursename LIKE '%"
                        + courseName + "%'";

            }

            // Search by both Student Name and Course Name
            else {

                Query = "SELECT * FROM feedback WHERE coursename LIKE '%"
                        + courseName
                        + "%' OR studentname LIKE '%"
                        + StudentName + "%'";

            }

            System.out.println("SQL Query: " + Query);

            res.setContentType("text/html;charset=UTF-8");

            PrintWriter out = res.getWriter();

            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(Query);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Student Feedback</title>");
            out.println("</head>");

            out.println("<body>");

            out.println("<h2>Student Feedback Details</h2>");

            out.println("<table border='1' cellpadding='10' cellspacing='0'>");

            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Student Name</th>");
            out.println("<th>Course Name</th>");
            out.println("<th>Rating</th>");
            out.println("<th>Comment</th>");
            out.println("</tr>");

            boolean found = false;

            while (rs.next()) {

                found = true;

                out.println("<tr>");

                out.println("<td>" + rs.getInt("id") + "</td>");

                out.println("<td>" + rs.getString("studentname") + "</td>");

                out.println("<td>" + rs.getString("coursename") + "</td>");

                out.println("<td>" + rs.getDouble("rating") + "</td>");

                out.println("<td>" + rs.getString("comment") + "</td>");

                out.println("</tr>");

            }

            if (!found) {

                out.println("<tr>");
                out.println("<td colspan='5'>No Feedback Found!</td>");
                out.println("</tr>");

            }

            out.println("</table>");

            out.println("</body>");
            out.println("</html>");

            rs.close();
            ps.close();
            con.close();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

}