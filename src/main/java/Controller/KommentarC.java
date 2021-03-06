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
        Benutzer user = (Benutzer) session.getAttribute("eingeloggterBenutzer");
        Arbeitsplan ap = (Arbeitsplan) session.getAttribute("ap");
        int index = Integer.parseInt((String) session.getAttribute("tag"));
        Tag tag = user.getTage().get(index);
        Kommentar comment = new Kommentar(tag);

        /* Kommentar in der Datenbank speichern */
        if (request.getParameter("submit").equals("submit")) {
            try {
                comment.setTag(tag.getDatum());
                comment.setInhalt(request.getParameter("kommentar"));
                comment.setBenutzer(user);
                kommentarDAO.save(comment);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.getRequestDispatcher("Kommentar/KommentarErfolg.jsp").forward(request, response);
            /* Die Tabellen für die Ansicht aus der Datenbank holen */
        } else if (request.getParameter("submit").equals("back")) {
            request.setAttribute("monat", String.format("%s %s", ap.getMonat(), ap.getYear()));
            request.setAttribute("dropdown", ap.getMonat());
            request.setAttribute("monatindex", ap.getMonatValue());
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
        Integer monat = (Integer) session.getAttribute("monat");
        Integer index = Integer.parseInt(request.getParameter("date"));
        List<Benutzer> users = null;
        boolean commentSet = false;
        try {
            users = benutzerDAO.getAllBenutzer();
            Arbeitsplan ap = new Arbeitsplan();
            if (monat == null) {
                for (Benutzer bn : users) {
                    List<Tag> days = tagDAO.getDays(ap.getAktuellesDatum().toLocalDate().getYear(), bn);
                    List<Tag> buffer = days.stream().filter(d -> (d.getBenutzer().getBid() == (bn.getBid())) && d.getDatum().toString().equals(ap.getStartDate().toString()) || d.getDatum().after(ap.getStartDate())).collect(Collectors.toList());
                    bn.setTage(buffer);
                    if (bn.getBid() == user.getBid() && bn.getTage().get(index).getKommentar() != null) {
                        commentSet = true;
                    }
                    request.setAttribute("monat", String.format("%s %s", ap.getMonat(), ap.getYear()));
                    request.setAttribute("dropdown", ap.getMonat());
                    request.setAttribute("monatindex", ap.getMonatValue());
                    request.setAttribute("benutzer", users);
                }
                /* Bestimmter Monat gewählt der Angezeigt werden soll */
            } else {
                for (Benutzer bn : users) {
                    List<Tag> days = tagDAO.getDays(ap.getAktuellesDatum().toLocalDate().getYear(), bn);
                    List<Tag> buffer = days.stream().filter(d -> (d.getBenutzer().getBid() == (bn.getBid())) && d.getDatum().toString().equals(ap.getStartDate(monat).toString()) || d.getDatum().after(ap.getStartDate(monat))).collect(Collectors.toList());
                    bn.setTage(buffer);
                    if (bn.getBid() == user.getBid() && bn.getTage().get(index).getKommentar() != null) {
                        commentSet = true;
                    }
                }
                request.setAttribute("benutzer", users);
                request.setAttribute("monat", String.format("%s %s", ap.getMonat(monat), ap.getYear()));
                request.setAttribute("monatindex", monat);
                request.setAttribute("dropdown", ap.getMonat(monat));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (user == null || user.getBenutzername() == null) {
            response.sendRedirect("Login/Login.jsp");
        } else if ((commentSet && user.getAdmin()) || ((user.getAdmin() && index == null) || user.getBenutzername().equals("root") && user.getPasswort().equals("root"))) {
            request.getRequestDispatcher("Ansicht/Ansicht.jsp").forward(request, response);
        } else if ((commentSet && !user.getAdmin()) || (!user.getAdmin() && index == null)) {
            request.getRequestDispatcher("Ansicht/AnsichtMitarbeiter.jsp").forward(request, response);
        } else {
            session.setAttribute("tag", request.getParameter("date"));
            request.getRequestDispatcher("Kommentar/Kommentar.jsp").forward(request, response);
        }
    }
}