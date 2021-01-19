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
        Benutzer benutzer = (Benutzer) session.getAttribute("eingeloggterBenutzer");

        if (session.getAttribute("username") == null) {
            response.sendRedirect("Login/Login.jsp");
        } else {

            try {
                List<Benutzer> user = benutzerDAO.getAllBenutzer();
                Arbeitsplan ap = new Arbeitsplan();

                if (request.getParameter("selectmonth") == null || request.getParameter("selectmonth").equalsIgnoreCase("Arbeitsplanansicht")) {
                    request.setAttribute("monat", ap.getMonat());
                    for (Benutzer bn : user) {
                        List<Tag> days = tagDAO.getDays(ap.getAktuellesDatum().toLocalDate().getYear() ,bn);
                        List<Tag> buffer = days.stream().filter(d -> (d.getBenutzer().getBid() == (bn.getBid())) && d.getDatum().toString().equals(ap.getStartDate().toString()) || d.getDatum().after(ap.getStartDate())).collect(Collectors.toList());
                        bn.setTage(buffer);
                        if (bn.getBid() == benutzer.getBid()) {
                            session.setAttribute("eingeloggterBenutzer", bn);
                            session.setAttribute("year", ap.getYear());
                        }
                    }
                } else {
                    int month = Integer.parseInt(request.getParameter("selectmonth"));
                    request.setAttribute("monat", ap.getMonat(month));
                    for (Benutzer bn : user) {
                        List<Tag> days = tagDAO.getDays(ap.getAktuellesDatum().toLocalDate().getYear() ,bn);
                        List<Tag> buffer = days.stream().filter(d -> (d.getBenutzer().getBid() == (bn.getBid())) && d.getDatum().toString().equals(ap.getStartDate(Integer.parseInt(request.getParameter("selectmonth"))).toString()) || d.getDatum().after(ap.getStartDate(Integer.parseInt(request.getParameter("selectmonth"))))).collect(Collectors.toList());
                        bn.setTage(buffer);
                        if (bn.getBid() == benutzer.getBid()) {
                            session.setAttribute("eingeloggterBenutzer", bn);
                            session.setAttribute("year", ap.getYear());
                        }
                    }
                }
                request.setAttribute("benutzer", user);
                request.getRequestDispatcher("Ansicht/Ansicht.jsp").forward(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
