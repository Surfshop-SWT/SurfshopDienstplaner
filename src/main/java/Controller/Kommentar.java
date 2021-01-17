package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 08.01.2021
 */
@WebServlet(name = "kommentar", value="/kommentar")
public class Kommentar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("username") == null) {
            response.sendRedirect("Login/Login.jsp");
        } else {
            request.getRequestDispatcher("Kommentar/Kommentar.jsp").forward(request, response);
        }
    }
}
