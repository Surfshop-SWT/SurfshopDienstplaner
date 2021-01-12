package Controller;

import DAO.BenutzerDAO;
import Model.Benutzer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 06.01.2021
 */
@WebServlet(name = "ansicht", value = "/ansicht")
public class Ansicht extends HttpServlet {

    private final BenutzerDAO benutzerDAO = new BenutzerDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("username") == null) {
            response.sendRedirect("Login/Login.jsp");
        } else {

            try {
                List<Benutzer> user = benutzerDAO.getAllBenutzer();
                System.out.println(user.isEmpty());
                request.setAttribute("benutzer", user);
                request.getRequestDispatcher("Ansicht/Ansicht.jsp").forward(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
