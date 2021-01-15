<%--
  Created by IntelliJ IDEA.
  User: Tim Lueneburg
  Date: 15.01.2021
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Benutzerübersicht</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<link href="KommentarSetzen.css"
      rel="stylesheet" type="text/css">
<body>

<div class="header">
    <div class="arbeitsplan"><input class="knopf choosen" type="submit" value="ARBEITSPLANANSICHT"></div>
    <div class="benutzer"><input class="knopf" type="submit" value="BENUTZERÜBERSICHT"></div>
    <div class="benutzerkonto"><input class="knopf" type="submit" value="BENUTZERKONTO"></div>
    <div class="logout"><input class="knopf" type="submit" value="ABMELDEN"></div>
</div>

<div class="main">
    <form>
        <div class="textwrapper"><textarea cols="2" rows="10" placeholder="Kommentar setzen..."></textarea></div>
        <p class="max-zeichen">Max. 300 Zeichen</p>
        <button id="abbrechen" type="submit" name="submit" class="button">Abbrechen</button>
        <button id="bestaetigen" type="submit" name="submit" class="button">Bestätigen</button>
    </form>
    <div class="erfolg-box">
        <p class="erfolg-text">Der Kommentar wurde erfolgreich gesetzt</p>
        <button id="zurueck" type="submit" name="submit">Zurück</button>
    </div>
    <div class="abbrechen-box">
        <p class="abbrechen-text">Sicher, dass Sie abbrechen wollen?</p>
        <button id="ja" type="submit" name="submit" class="button">Ja</button>
        <button id="nein" type="submit" name="submit" class="button">Nein</button>
    </div>
</div>


</div>
</body>
</html>
