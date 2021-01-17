package Controller;

import DAO.BenutzerDAO;
import Model.Benutzer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 12.01.2021
 */
@WebServlet(name = "benutzerubersicht", value = "/benutzerubersicht")
public class Benutzerubersicht extends HttpServlet {

    private final BenutzerDAO benutzerDAO = new BenutzerDAO();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {

        //Den Charset für die request setzen damit Umlaute genommen werden (Standard: ISO_8859_1) Wir brauchen UTF-8
        request.setCharacterEncoding("UTF-8");

        request.getRequestDispatcher("BenutzerAnlegen/BenutzerAnlegen.jsp").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("username") == null) {
            response.sendRedirect("Login/Login.jsp");
        } else {
            /* Den Benutzer Objekt an die JSP geben */
            List<Benutzer> allUser = new LinkedList<>();
            try {
                allUser = benutzerDAO.getAllBenutzer();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            request.setAttribute("benutzer", allUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Benutzerubersicht/Benutzerubersicht.jsp");
            dispatcher.forward(request, response);
        }
    }

}
