package Controller;

import DAO.BenutzerDAO;
import DAO.TagDAO;
import Model.Arbeitsplan;
import Model.Benutzer;
import Model.Tag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 23.12.2020
 */
@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {

    private final BenutzerDAO benutzerDAO = new BenutzerDAO();
    private final TagDAO tagDAO = new TagDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname = request.getParameter("username");
        String pass = request.getParameter("password");
        try {
            /* Prüfen ob die Anmeldedaten richtig sind (muss noch verfeinert werden) */
            if (benutzerDAO.checkLogin(uname, pass)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", uname);
                /* Den Benutzer Objekt an die JSP geben */
                List<Benutzer> user = benutzerDAO.getAllBenutzer();
                Arbeitsplan ap = new Arbeitsplan();
                for (Benutzer bn : user) {
                    List<Tag> days = tagDAO.getDays(ap.getAktuellesDatum().toLocalDate().getYear() ,bn);
                    List<Tag> buffer = days.stream().filter(d -> (d.getBenutzer().getBid() == (bn.getBid())) && d.getDatum().toString().equals(ap.getStartDate().toString()) || d.getDatum().after(ap.getStartDate())).collect(Collectors.toList());
                    bn.setTage(buffer);
                }
                request.setAttribute("date", ap);
                request.setAttribute("benutzer", user);
                request.setAttribute("monat", ap.getMonat());
                request.getRequestDispatcher("Ansicht/Ansicht.jsp").forward(request, response);
            } else {
                /* Fehlermeldung wenn die Logindaten nicht stimmen */
                request.setAttribute("errorMessage", "Benutzername und/oder Passwort ist falsch!");
                request.getRequestDispatcher("Login/Login.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Login/Login.jsp");
    }
}
