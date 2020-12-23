<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Dienstplan</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="Login/Login.css"
          rel="stylesheet" type="text/css">
</head>
<body>

<!-- Main Block -->
<div id="main">

    <!-- Überschriften Block -->
    <div id="ueberschriftwrapper">
        <div id="logo-Arbeitsplan">Arbeitsplan</div>
        <div id="logo-Anmelden">Anmelden</div>
    </div>


    <!-- Form zum Eingeben der Daten und dann zum Servlet senden -->
    <form action="login" method="post">
        <!-- Eingaben Block -->
        <div id="eingabewrapper">
            <input type="text" name="username" class="username" placeholder="Benutzername"><br>
            <input type="password" name="password" class="password" placeholder="Passwort"><br>
            <button id="login" type="submit" name="submit" class="button">Login</button>
            <br>
            <p style="color: green;">${successMessage}</p>
            <p style="color: red;">${errorMessage}</p>
        </div>
    </form>
</div>
</body>
</html>