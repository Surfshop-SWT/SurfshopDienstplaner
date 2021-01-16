<%--
  Created by IntelliJ IDEA.
  User: Tim Lueneburg
  Date: 06.01.2021
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link href="${pageContext.request.contextPath}/Ansicht/Ansicht3.css"
      rel="stylesheet" type="text/css">
<body>

<div class="header">
    <div class="arbeitsplan"><input class="knopf choosen" type="submit" value="ARBEITSPLANANSICHT"></div>
    <form action="${pageContext.request.contextPath}/benutzerubersicht" method="get" accept-charset="utf-8">
        <div class="benutzer"><input class="knopf" type="submit" value="BENUTZERÜBERSICHT"></div>
    </form>
    <div class="benutzerkonto"><input class="knopf" type="submit" value="BENUTZERKONTO"></div>
    <form action="${pageContext.request.contextPath}/logout" method="get">
        <div class="logout"><input class="knopf" type="submit" value="ABMELDEN"></div>
    </form>
</div>
<div class="main">
    <div class="left-main">
        <form action="${pageContext.request.contextPath}/ansicht" method="get">
            <div id="menu">
                <ul>
                    <li class="topmenu selected">
                        <a id="monatDropDown">${monat}</a>
                        <ul>
                            <li class="submenu">
                                <button name="selectmonth" type="submit" value="0">Januar</button>
                            </li>
                            <li class="submenu">
                                <button name="selectmonth" type="submit" value="1">Februar</button>
                            </li>
                            <li class="submenu">
                                <button name="selectmonth" type="submit" value="2">März</button>
                            </li>
                            <li class="submenu">
                                <button name="selectmonth" type="submit" value="3">April</button>
                            </li>
                            <li class="submenu">
                                <button name="selectmonth" type="submit" value="4">Mai</button>
                            </li>
                            <li class="submenu">
                                <button name="selectmonth" type="submit" value="5">Juni</button>
                            </li>
                            <li class="submenu">
                                <button name="selectmonth" type="submit" value="6">Juli</button>
                            </li>
                            <li class="submenu">
                                <button name="selectmonth" type="submit" value="7">August</button>
                            </li>
                            <li class="submenu">
                                <button name="selectmonth" type="submit" value="8">September</button>
                            </li>
                            <li class="submenu">
                                <button name="selectmonth" type="submit" value="9">Oktober</button>
                            </li>
                            <li class="submenu">
                                <button name="selectmonth" type="submit" value="10">November</button>
                            </li>
                            <li class="submenu">
                                <button name="selectmonth" type="submit" value="11">Dezember</button>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </form>
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
                <c:forEach var="user" items="${benutzer}">
            <tr>
                <td class="mitarbeiter">${user.vorname}, ${user.nachname}</td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day urlaub"></td>
                <td class="day urlaub"></td>
                <td class="day urlaub"></td>
                <td class="day urlaub"></td>
                <td class="day urlaub"></td>
                <td class="soll">6</td>
                <td class="ist">4</td>
            </tr>
            </c:forEach>
            </tr>
        </table>
        <table>
            <tr class="table-head">
                <tbody id="tableHeader1"></tbody>
                <c:forEach var="user" items="${benutzer}">
            <tr>
                <td class="mitarbeiter">${user.vorname}, ${user.nachname}</td>
                <td class="day"></td>
                <td class="day frei"></td>
                <td class="day frei"></td>
                <td class="day frei"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="soll">6</td>
                <td class="ist">4</td>
            </tr>
            </c:forEach>
            </tr>
        </table>
        <table>
            <tr class="table-head">
                <tbody id="tableHeader2"></tbody>
                <c:forEach var="user" items="${benutzer}">
            <tr>
                <td class="mitarbeiter">${user.vorname}, ${user.nachname}</td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="soll">6</td>
                <td class="ist">4</td>
            </tr>
            </c:forEach>
            </tr>
        </table>
        <table>
            <tr class="table-head">
                <tbody id="tableHeader3"></tbody>
                <c:forEach var="user" items="${benutzer}">
            <tr>
                <td class="mitarbeiter">${user.vorname}, ${user.nachname}</td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="soll">6</td>
                <td class="ist">4</td>
            </tr>
            </c:forEach>
            </tr>
        </table>
        <table id="table4">
            <tr class="table-head">
                <tbody id="tableHeader4"></tbody>
                <c:forEach var="user" items="${benutzer}">
            <tr>
                <td class="mitarbeiter">${user.vorname}, ${user.nachname}</td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="day"></td>
                <td class="soll">6</td>
                <td class="ist">4</td>
            </tr>
            </c:forEach>
            </tr>
        </table>
        </body>
    </div>
</div>
</div>

</body>
</html>