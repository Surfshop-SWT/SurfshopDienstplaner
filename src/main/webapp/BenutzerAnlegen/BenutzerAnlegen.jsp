<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Dienstplan</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/BenutzerAnlegen/BenutzerAnlegen.css"
          rel="stylesheet" type="text/css">
</head>
<body>
<!-- Main Block -->
<div id="main" items="${eingaben}">

    <!-- Form zum Eingeben der Daten und dann zum Servlet senden -->
    <form action="${pageContext.request.contextPath}/benutzerAnlegen" method="post" accept-charset="utf-8">


        <!-- Überschriften Block -->
        <div id="ueberschrift">
            <div id="logo-Arbeitsplan">Arbeitsplan</div>
            <div id="logo-Benutzer-Anmelden">Benutzer Anlegen</div>
        </div>

        <!-- Block aller Eingaben -->
        <div class="eingabewrapper">
            <input id="vorname" type="text" name="vorname" class="forename" placeholder="Vorname" value="${eingaben.get(0)}" required>
            <input id="name" type="text" name="name" class="name" placeholder="Name" value="${eingaben.get(1)}" required>
            <input id="email" type="email" name="email" class="email" placeholder="E-Mail-Adresse" value="${eingaben.get(2)}" required>
            <input id="telefonnummer" type="number" name="telefonnummer" class="telefonnummer"
                   placeholder="Telefonnummer" value="${eingaben.get(3)}" required>

            <!-- ClearFix -->
            <div class="clear"></div>
        </div>

        <!-- Block der Eingaben für Login -->
        <div id="eingabeLoginwrapper">
            <div id="username">
                <input id="benutzername" type="text" name="benutzername" class="benutzername"
                       placeholder="Benutzername"
                       value="" required>
                <label id="benutzernameHinweis" for="benutzername">3-16 Zeichen</label>
            </div>
            <div id="password">
                <input id="passwort" type="password" name="passwort" class="passwort" placeholder="Passwort"
                       value="" required>
                <label id="passwortHinweis" for="passwort">mind. 4 Zeichen</label>
            </div>

            <!-- ClearFix -->
            <div class="clear"></div>
        </div>

        <!-- Block für Eingabe der Urlaubstage -->
        <div class="eingabewrapper">
            <input id="urlaubstage" type="number" name="urlaubstage" class="urlaubstage" placeholder="Urlaubstage"
                   value="${eingaben.get(4)}" required>

            <!-- ClearFix -->
            <div class="clear"></div>
        </div>

        <!-- Block für Auswahl Arbeitszeit und Benutzerrolle -->
        <div id="auswahlwrapper">
            <table>
                <tr>
                    <td>Arbeitszeit:</td>
                    <td><input type="radio" name="arbeitszeit" value="vollzeit" class="radio" id="vollzeit" required>
                        <label for="vollzeit">Vollzeit</label></td>
                    <td><input type="radio" name="arbeitszeit" value="teilzeit" class="radio" id="teilzeit">
                        <label for="teilzeit">Teilzeit</label><br></td>
                </tr>
                <tr>
                    <td>Benutzerrolle:</td>
                    <td><input type="radio" name="benutzerrolle" value="mitarbeiter" class="radio"
                               id="mitarbeiter" checked="checked">
                        <label for="mitarbeiter">Mitarbeiter</label></td>
                    <td><input type="radio" name="benutzerrolle" value="chef" class="radio" id="chef">
                        <label for="chef">Chef</label></td>
                </tr>
            </table>
            <p style="color: red;">${errorMessage}</p>
            <button id="abbrechen" type="submit" name="submit" class="button">Abbrechen</button>
            <button id="bestätigen" type="submit" name="submit" class="button">Bestätigen</button>
        </div>
    </form>
</div>
</body>
</html>