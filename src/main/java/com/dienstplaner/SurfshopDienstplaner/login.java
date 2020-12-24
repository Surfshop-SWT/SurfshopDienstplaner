package com.dienstplaner.SurfshopDienstplaner;

import Model.Benutzer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 23.12.2020
 */
@WebServlet(name = "login", value="/login")
public class login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Benutzer user = new Benutzer();

        if (user.isValid(request.getParameter("username"), request.getParameter("password"))) {
            request.getRequestDispatcher("BenutzerAnlegen/BenutzerAnlegen.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Login Daten sind nicht Korrekt, bitte noch mal versuchen!");
            request.getRequestDispatcher("Login/Login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
