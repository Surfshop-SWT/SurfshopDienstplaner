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
            <ul>
                <li class="topmenu selected">
                    <a href="">Dezember</a>
                    <ul>
                        <li class="submenu"><a href="">Januar</a></li>
                        <li class="submenu"><a href="">Februar</a></li>
                        <li class="submenu"><a href="">März</a></li>
                        <li class="submenu"><a href="">April</a></li>
                        <li class="submenu"><a href="">Mai</a></li>
                        <li class="submenu"><a href="">Juni</a></li>
                        <li class="submenu"><a href="">Juli</a></li>
                        <li class="submenu"><a href="">August</a></li>
                        <li class="submenu"><a href="">September</a></li>
                        <li class="submenu"><a href="">Oktober</a></li>
                        <li class="submenu"><a href="">Noveber</a></li>
                        <li class="submenu selected"><a href="">Dezember</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="temp">
            <p>Hinweis:<br> Für erweiterte Optionen auf den jeweiligen Wochentag klicken</p>
            <button id="drucken" class="button" onclick="printPageArea('printview')">Drucken</button>
        </div>
    </div>
    <div id="printview" class="right-main">
        <body>
        <table>
            <tr class="table-head">
            <tbody id="tableHeader"></tbody>
            </tr>
        </table>
        </body>
    </div>
</div>
</div>

</body>
</html>