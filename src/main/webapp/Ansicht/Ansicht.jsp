<%--
  Created by IntelliJ IDEA.
  User: Tim Lueneburg
  Date: 06.01.2021
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Dienstplaner</title>
</head>
<script src="${pageContext.request.contextPath}/Ansicht/Ansicht.js" type="text/javascript">
</script>
<link href="${pageContext.request.contextPath}/Ansicht/Ansicht2.css"
      rel="stylesheet" type="text/css">
<body>

<div class="header">
    <div class="arbeitsplan"><input class="knopf choosen" type="submit" value="ARBEITSPLANANSICHT"></div>
    <div class="benutzer"><input class="knopf" type="submit" value="BENUTZERÜBERSICHT"></div>
    <div class="benutzerkonto"><input class="knopf" type="submit" value="BENUTZERKONTO"></div>
    <form action="${pageContext.request.contextPath}/logout" method="get">
        <div class="logout"><input class="knopf" type="submit" value="ABMELDEN"></div>
    </form>
</div>
<div class="main">
    <div class="left-main">
        <div id="menu">

        </div>
        <div class="temp">
            <p>Hinweis:<br> Für erweiterte Optionen auf den jeweiligen Wochentag klicken</p>
            <button id="drucken" class="button" onclick="printPageArea('printview')">Drucken</button>
        </div>
    </div>
    <div id="printview" class="right-main">
        <body>
        <table>
            <caption id="monatsAnsicht"></caption>
            <tr class="table-head">
                <tbody id="tableHeader0"></tbody>
            </tr>
        </table>
        <table>
            <tr class="table-head">
                <tbody id="tableHeader1"></tbody>
            </tr>
        </table>
        <table>
            <tr class="table-head">
                <tbody id="tableHeader2"></tbody>
            </tr>
        </table>
        <table>
            <tr class="table-head">
                <tbody id="tableHeader3"></tbody>
            </tr>
        </table>
        <table>
            <tr class="table-head">
                <tbody id="tableHeader4"></tbody>
            </tr>
        </table>
        </body>
    </div>
</div>
</div>

</body>
</html>