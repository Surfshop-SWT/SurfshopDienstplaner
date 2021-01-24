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
 * Date: 06.01.2021
 */
@WebServlet(name = "ansicht", value = "/ansicht")
public class Ansicht extends HttpServlet {

    private final BenutzerDAO benutzerDAO = new BenutzerDAO();
    private final TagDAO tagDAO = new TagDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Benutzer> user = null;
        try {
            user = benutzerDAO.getAllBenutzer();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("benutzer", user);
        request.getRequestDispatcher("Ansicht/Ansicht.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Benutzer user = (Benutzer) session.getAttribute("eingeloggterBenutzer");
        Arbeitsplan ap = (Arbeitsplan) session.getAttribute("ap");

        if (user == null || user.getBenutzername() == null) {
            response.sendRedirect("Login/Login.jsp");
        } else {

            try {
                List<Benutzer> users = benutzerDAO.getAllBenutzer();
                /* Es wurde keine spezieller Monat gewählt, zeigt den aktuellen Monat an */
                if (request.getParameter("selectmonth") == null || request.getParameter("selectmonth").equalsIgnoreCase("Arbeitsplanansicht")) {
                    request.setAttribute("monat", String.format("%s %s", ap.getMonat(), ap.getYear()));
                    request.setAttribute("monatindex", ap.getMonatValue());
                    request.setAttribute("dropdown", ap.getMonat());
                    for (Benutzer bn : users) {
                        List<Tag> days = tagDAO.getDays(ap.getAktuellesDatum().toLocalDate().getYear() ,bn);
                        List<Tag> buffer = days.stream().filter(d -> (d.getBenutzer().getBid() == (bn.getBid())) && d.getDatum().toString().equals(ap.getStartDate().toString()) || d.getDatum().after(ap.getStartDate())).collect(Collectors.toList());
                        bn.setTage(buffer);
                        if (bn.getBid() == user.getBid()) {
                            session.setAttribute("eingeloggterBenutzer", bn);
                        }
                    }
                    /* Bestimmter Monat gewählt der Angezeigt werden soll */
                } else {
                    int month = Integer.parseInt(request.getParameter("selectmonth"));
                    session.setAttribute("monat", month);
                    request.setAttribute("monat", String.format("%s %s", ap.getMonat(month), ap.getYear()));
                    request.setAttribute("monatindex", month);
                    request.setAttribute("dropdown", ap.getMonat(month));
                    for (Benutzer bn : users) {
                        List<Tag> days = tagDAO.getDays(ap.getAktuellesDatum().toLocalDate().getYear() ,bn);
                        List<Tag> buffer = days.stream().filter(d -> (d.getBenutzer().getBid() == (bn.getBid())) && d.getDatum().toString().equals(ap.getStartDate(Integer.parseInt(request.getParameter("selectmonth"))).toString()) || d.getDatum().after(ap.getStartDate(Integer.parseInt(request.getParameter("selectmonth"))))).collect(Collectors.toList());
                        bn.setTage(buffer);
                        if (bn.getBid() == user.getBid()) {
                            session.setAttribute("eingeloggterBenutzer", bn);
                        }
                    }
                }
                request.setAttribute("benutzer", users);
                if (user.getAdmin()) {
                    request.getRequestDispatcher("Ansicht/Ansicht.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Ansicht/AnsichtMitarbeiter.jsp").forward(request, response);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
