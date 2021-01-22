package Controller;

import DAO.BenutzerDAO;
import DAO.KommentarDAO;
import DAO.TagDAO;
import Model.Arbeitsplan;
import Model.Benutzer;
import Model.Kommentar;
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
 * Date: 08.01.2021
 */
@WebServlet(name = "kommentar", value = "/kommentar")
public class KommentarC extends HttpServlet {

    private final BenutzerDAO benutzerDAO = new BenutzerDAO();
    private final KommentarDAO kommentarDAO = new KommentarDAO();
    private final TagDAO tagDAO = new TagDAO();

    /**
     * KommentarSetzen Funktion
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Kommentar comment = new Kommentar();
        Benutzer user = (Benutzer) session.getAttribute("eingeloggterBenutzer");
        Arbeitsplan ap = (Arbeitsplan) session.getAttribute("ap");
        int index = Integer.parseInt((String) session.getAttribute("tag"));
        Tag tag = user.getTage().get(index);

        /* Kommentar in der Datenbank speichern */
        if (request.getParameter("submit").equals("submit")) {
            try {
                comment.setTag(tag.getDatum());
                comment.setInhalt(request.getParameter("kommentar"));
                comment.setBenutzer(user);
                comment.setTag_id(tag.getTid());
                kommentarDAO.save(comment);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.getRequestDispatcher("Kommentar/KommentarErfolg.jsp").forward(request, response);
            /* Die Tabellen für die Ansicht aus der Datenbank holen */
        } else if (request.getParameter("submit").equals("back")) {
            request.setAttribute("monat", String.format("%s %s", ap.getMonat(), ap.getYear()));
            request.setAttribute("dropdown", ap.getMonat());
            List<Benutzer> users = null;
            try {
                users = benutzerDAO.getAllBenutzer();
                for (Benutzer bn : users) {
                    List<Tag> days = tagDAO.getDays(ap.getAktuellesDatum().toLocalDate().getYear(), bn);
                    List<Tag> buffer = days.stream().filter(d -> (d.getBenutzer().getBid() == (bn.getBid())) && d.getDatum().toString().equals(ap.getStartDate().toString()) || d.getDatum().after(ap.getStartDate())).collect(Collectors.toList());
                    bn.setTage(buffer);
                }
                request.setAttribute("benutzer", users);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (user.getAdmin()) {
                request.getRequestDispatcher("Ansicht/Ansicht.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("Ansicht/AnsichtMitarbeiter.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Benutzer user = (Benutzer) session.getAttribute("eingeloggterBenutzer");
        List<Benutzer> users = null;
        try {
            users = benutzerDAO.getAllBenutzer();
            Arbeitsplan ap = new Arbeitsplan();
            for (Benutzer bn : users) {
                List<Tag> days = tagDAO.getDays(ap.getAktuellesDatum().toLocalDate().getYear(), bn);
                List<Tag> buffer = days.stream().filter(d -> (d.getBenutzer().getBid() == (bn.getBid())) && d.getDatum().toString().equals(ap.getStartDate().toString()) || d.getDatum().after(ap.getStartDate())).collect(Collectors.toList());
                bn.setTage(buffer);
            }
            request.setAttribute("benutzer", users);
            request.setAttribute("monat", String.format("%s %s", ap.getMonat(), ap.getYear()));
            request.setAttribute("dropdown", ap.getMonat());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (user == null || user.getBenutzername() == null) {
            response.sendRedirect("Login/Login.jsp");
        } else if (user.getBenutzername().equals("root") && user.getPasswort().equals("root")) {
            request.getRequestDispatcher("Ansicht/Ansicht.jsp").forward(request, response);
        } else if (!user.getAdmin() && request.getParameter("date") == null) {
            request.getRequestDispatcher("Ansicht/AnsichtMitarbeiter.jsp").forward(request, response);
        } else {
            session.setAttribute("tag", request.getParameter("date"));
            request.getRequestDispatcher("Kommentar/Kommentar.jsp").forward(request, response);
        }
    }
}