package com.dienstplaner.SurfshopDienstplaner;

import DAO.BenutzerDAO;
import Model.Benutzer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 23.12.2020
 */
@WebServlet(name = "benutzerAnlegen", value = "/benuterAnlegen")
public class benutzerAnlegen extends HttpServlet {

    private final BenutzerDAO benutzerDAO = new BenutzerDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Den Charset für die request setzen damit Umlaute genommen werden (Standard: ISO_8859_1) Wir brauchen UTF-8
        request.setCharacterEncoding("UTF-8");

        Benutzer user = new Benutzer();

        try {
            if (!benutzerDAO.existsByName(request.getParameter("benutzername"))) {
                user.setVorname(request.getParameter("vorname"));
                user.setNachname(request.getParameter("name"));
                user.setEMailadresse(request.getParameter("email"));
                user.setTelefonnummer(request.getParameter("telefonnummer"));
                user.setUrlaubstage(Integer.parseInt(request.getParameter("urlaubstage")));
                user.setBenutzername(request.getParameter("benutzername"));
                user.setPasswort(request.getParameter("passwort"));
                benutzerDAO.save(user);
                request.getRequestDispatcher("BenutzerAnlegen/BenutzerAnlegen.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
