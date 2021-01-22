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

    /**
     * Anmelden mit Benutzername und Passowrt
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String uname = request.getParameter("username");
        String pass = request.getParameter("password");

        try {
            /* Prüfen ob die Anmeldedaten richtig sind (muss noch verfeinert werden) */
            if ((uname.equals("root") && pass.equals("root")) || benutzerDAO.checkLogin(uname, pass)) {
                boolean admin = false;
                if (uname.equals("root") && pass.equals("root")) {
                    Benutzer root = new Benutzer();
                    root.setBenutzername("root");
                    root.setPasswort("root");
                    root.setAdmin(true);
                    admin = true;
                    session.setAttribute("eingeloggterBenutzer", root);
                }
                List<Benutzer> users = benutzerDAO.getAllBenutzer();
                Arbeitsplan ap = new Arbeitsplan();
                for (Benutzer bn : users) {
                    List<Tag> days = tagDAO.getDays(ap.getAktuellesDatum().toLocalDate().getYear() ,bn);
                    List<Tag> buffer = days.stream().filter(d -> (d.getBenutzer().getBid() == (bn.getBid())) && d.getDatum().toString().equals(ap.getStartDate().toString()) || d.getDatum().after(ap.getStartDate())).collect(Collectors.toList());
                    bn.setTage(buffer);
                    if (bn.getBenutzername().equals(uname)) {
                        /* Den Eingeloggten Benutzer als Session Objekt übergeben */
                        session.setAttribute("eingeloggterBenutzer", bn);
                        if (bn.getAdmin()) {
                            admin = true;
                        }
                    }
                }
                session.setAttribute("ap", ap);
                request.setAttribute("benutzer", users);
                request.setAttribute("monat", String.format("%s %s", ap.getMonat(), ap.getYear()));
                request.setAttribute("dropdown", ap.getMonat());
                if (admin) {
                    request.getRequestDispatcher("Ansicht/Ansicht.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Ansicht/AnsichtMitarbeiter.jsp").forward(request, response);
                }
            } else {
                /* Fehlermeldung wenn die Logindaten nicht stimmen */
                request.setAttribute("errorMessage", "Benutzername und/oder Passwort ist falsch!");
                request.getRequestDispatcher("Login/Login.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("Login/Login.jsp");
    }
}
