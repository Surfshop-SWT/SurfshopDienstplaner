package Controller;

import DAO.BenutzerDAO;
import DAO.TagDAO;
import Model.Arbeitsplan;
import Model.Benutzer;
import Model.Tag;

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
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 12.01.2021
 */
@WebServlet(name = "benutzerubersicht", value = "/benutzerubersicht")
public class Benutzerubersicht extends HttpServlet {

    private final BenutzerDAO benutzerDAO = new BenutzerDAO();
    private final TagDAO tagDAO = new TagDAO();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {

        //Den Charset für die request setzen damit Umlaute genommen werden (Standard: ISO_8859_1) Wir brauchen UTF-8
        request.setCharacterEncoding("UTF-8");

        request.getRequestDispatcher("BenutzerAnlegen/BenutzerAnlegen.jsp").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Benutzer user = (Benutzer) session.getAttribute("eingeloggterBenutzer");
        Arbeitsplan ap = (Arbeitsplan) session.getAttribute("ap");

        if (user.getBenutzername() == null) {
            response.sendRedirect("Login/Login.jsp");
        } else if (user.getAdmin()) {
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
        } else {
            List<Benutzer> users = new LinkedList<>();
            try {
                users = benutzerDAO.getAllBenutzer();
                request.setAttribute("monat", String.format("%s %s", ap.getMonat(), ap.getYear()));
                request.setAttribute("dropdown", ap.getMonat());
                for (Benutzer bn : users) {
                    List<Tag> days = tagDAO.getDays(ap.getAktuellesDatum().toLocalDate().getYear() ,bn);
                    List<Tag> buffer = days.stream().filter(d -> (d.getBenutzer().getBid() == (bn.getBid())) && d.getDatum().toString().equals(ap.getStartDate().toString()) || d.getDatum().after(ap.getStartDate())).collect(Collectors.toList());
                    bn.setTage(buffer);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            request.setAttribute("benutzer", users);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Ansicht/AnsichtMitarbeiter.jsp");
            dispatcher.forward(request, response);
        }
    }
}