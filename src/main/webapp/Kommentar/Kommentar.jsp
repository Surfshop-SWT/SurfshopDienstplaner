<%--
  Created by IntelliJ IDEA.
  User: Tim Lueneburg
  Date: 15.01.2021
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Benutzerübersicht</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<script src="${pageContext.request.contextPath}/Kommentar/Kommentar.js" type="text/javascript">
</script>
<link href="${pageContext.request.contextPath}/Kommentar/Kommentar5.css"
      rel="stylesheet" type="text/css">
<body>

<div class="header">
    <form action="${pageContext.request.contextPath}/ansicht" method="get">
        <div class="arbeitsplan"><input class="knopf" type="submit" value="ARBEITSPLANANSICHT"></div>
    </form>
    <form action="${pageContext.request.contextPath}/benutzerubersicht" method="get">
        <div class="benutzer"><input class="knopf" type="submit" value="BENUTZERÜBERSICHT"></div>
    </form>
    <div class="benutzerkonto"><input class="knopf" type="submit" value="BENUTZERKONTO"></div>
    <form action="${pageContext.request.contextPath}/logout" method="get">
        <div class="logout"><input class="knopf" type="submit" value="ABMELDEN"></div>
    </form>
</div>

<div class="main">
    <form id="eingabeboxwrapper" action="${pageContext.request.contextPath}/kommentar" method="post">
        <div class="textwrapper"><label><textarea id="kommentar" name="kommentar" cols="2" rows="10" placeholder="Kommentar setzen..." onblur="commentLength()"></textarea></label></div>
        <p class="max-zeichen">Max. 300 Zeichen</p>
        <div id="yesornowrapper">
            <button id="abbrechen" type="button" name="submit" class="button" onclick="cancleComment()">Abbrechen
            </button>
            <button id="bestaetigen" type="submit" name="submit" class="button" value="submit">Bestätigen</button>
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/ansicht" method="get">
        <div id="abbrechen-box">
            <p class="abbrechen-text">Sicher, dass sie Abbrechen wollen?</p>
            <button id="ja" type="submit" class="button">Ja</button>
            <button id="nein" type="button" class="button" onclick="cancleComment()">Nein</button>
        </div>
    </form>
</div>
</body>
</html>
