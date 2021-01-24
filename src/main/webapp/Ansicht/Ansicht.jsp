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
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Dienstplaner</title>
</head>
<script src="${pageContext.request.contextPath}/Ansicht/Ansicht5.js" type="text/javascript">
</script>
<script type="text/javascript">
    var monatindex = ${monatindex};
</script>
<link href="${pageContext.request.contextPath}/Ansicht/Ansicht5.css"
      rel="stylesheet" type="text/css">
<body>

<div class="header d-none d-md-block">
    <div class="arbeitsplan"><input class="knopf choosen" type="submit" value="ARBEITSPLANANSICHT"></div>
    <form action="${pageContext.request.contextPath}/benutzerubersicht" method="get" accept-charset="utf-8">
        <div class="benutzer"><input class="knopf" type="submit" value="BENUTZERÜBERSICHT"></div>
    </form>
    <div class="benutzerkonto"><input class="knopf" type="submit" value="BENUTZERKONTO"></div>
    <form action="${pageContext.request.contextPath}/logout" method="get">
        <div class="logout"><input class="knopf" type="submit" value="ABMELDEN"></div>
    </form>
</div>
<div class="container-fluid mt-2">
    <div class="row">
        <div class="col d-md-none">
            <p> Machen Sie bitte diesem Bildschirm großer</p>
        </div>
        <div class="col-lg-2 col-md-12 d-none d-md-block">
            <form action="${pageContext.request.contextPath}/ansicht" method="get">
                <div id="menu">
                    <ul>
                        <li class="topmenu selected">
                            <a id="monatDropDown">${dropdown}</a>
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
            <div class="buffer d-md-none d-lg-block"></div>
            <div class="temp">
                <p>Hinweis:<br> Für erweiterte Optionen auf den jeweiligen Wochentag klicken</p>
                <button id="drucken" class="button" onclick="printPageArea('printview')">Drucken</button>
            </div>
        </div>
        <div class="col-lg-10 col-md-12 d-none d-md-block">
            <div id="printview">
                <body>
                <table>
                    <caption id="monatsAnsicht">${monat}</caption>
                    <tr class="table-head">
                        <tbody id="tableHeader0"></tbody>
                        <c:forEach var="user" items="${benutzer}">
                    <tr>
                        <td class="mitarbeiter">${user.vorname}, ${user.nachname}</td>
                        <td class="day ${user.getTage()[0].getArt().toString().toLowerCase()}"><div class="${user.getTage()[0].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[1].getArt().toString().toLowerCase()}"><div class="${user.getTage()[1].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[2].getArt().toString().toLowerCase()}"><div class="${user.getTage()[2].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[3].getArt().toString().toLowerCase()}"><div class="${user.getTage()[3].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[4].getArt().toString().toLowerCase()}"><div class="${user.getTage()[4].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[5].getArt().toString().toLowerCase()}"><div class="${user.getTage()[5].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[6].getArt().toString().toLowerCase()}"><div class="${user.getTage()[6].getKommentar() != null ? "dot" : ""}"></div></td>
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
                        <td class="day ${user.getTage()[7].getArt().toString().toLowerCase()}"><div class="${user.getTage()[7].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[8].getArt().toString().toLowerCase()}"><div class="${user.getTage()[8].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[9].getArt().toString().toLowerCase()}"><div class="${user.getTage()[9].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[10].getArt().toString().toLowerCase()}"><div class="${user.getTage()[10].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[11].getArt().toString().toLowerCase()}"><div class="${user.getTage()[11].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[12].getArt().toString().toLowerCase()}"><div class="${user.getTage()[12].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[13].getArt().toString().toLowerCase()}"><div class="${user.getTage()[13].getKommentar() != null ? "dot" : ""}"></div></td>
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
                        <td class="day ${user.getTage()[14].getArt().toString().toLowerCase()}"><div class="${user.getTage()[14].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[15].getArt().toString().toLowerCase()}"><div class="${user.getTage()[15].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[16].getArt().toString().toLowerCase()}"><div class="${user.getTage()[16].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[17].getArt().toString().toLowerCase()}"><div class="${user.getTage()[17].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[18].getArt().toString().toLowerCase()}"><div class="${user.getTage()[18].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[19].getArt().toString().toLowerCase()}"><div class="${user.getTage()[19].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[20].getArt().toString().toLowerCase()}"><div class="${user.getTage()[20].getKommentar() != null ? "dot" : ""}"></div></td>
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
                        <td class="day ${user.getTage()[21].getArt().toString().toLowerCase()}"><div class="${user.getTage()[21].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[22].getArt().toString().toLowerCase()}"><div class="${user.getTage()[22].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[23].getArt().toString().toLowerCase()}"><div class="${user.getTage()[23].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[24].getArt().toString().toLowerCase()}"><div class="${user.getTage()[24].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[25].getArt().toString().toLowerCase()}"><div class="${user.getTage()[25].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[26].getArt().toString().toLowerCase()}"><div class="${user.getTage()[26].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[27].getArt().toString().toLowerCase()}"><div class="${user.getTage()[27].getKommentar() != null ? "dot" : ""}"></div></td>
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
                        <td class="day ${user.getTage()[28].getArt().toString().toLowerCase()}"><div class="${user.getTage()[28].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[29].getArt().toString().toLowerCase()}"><div class="${user.getTage()[29].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[30].getArt().toString().toLowerCase()}"><div class="${user.getTage()[30].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[31].getArt().toString().toLowerCase()}"><div class="${user.getTage()[31].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[32].getArt().toString().toLowerCase()}"><div class="${user.getTage()[32].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[33].getArt().toString().toLowerCase()}"><div class="${user.getTage()[33].getKommentar() != null ? "dot" : ""}"></div></td>
                        <td class="day ${user.getTage()[34].getArt().toString().toLowerCase()}"><div class="${user.getTage()[34].getKommentar() != null ? "dot" : ""}"></div></td>
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
</div>

</body>
</html>