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
            <button id="drucken" type="submit" name="submit" class="button">Drucken</button>
        </div>
    </div>
    <div class="right-main">
        <div class="table">
            <table id="table1">
                <caption>Dezember 2020</caption>
                <tr class="table-head">
                    <th class="date">Date</th>
                    <th class="day">Montag</th>
                    <th class="day">Dienstag</th>
                    <th class="day">Mittwoch</th>
                    <th class="day">Donnerstag</th>
                    <th class="day">Freitag</th>
                    <th class="day">Samstag</th>
                    <th class="day">Sonntag</th>
                    <th class="soll">Soll</th>
                    <th class="ist">Ist</th>
                </tr>
                <tr>
                    <td class="mitarbeiter">Nitsch, Simon</td>
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
                <tr>
                    <td class="mitarbeiter">Alipkina, Denis</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day frei"></td>
                    <td class="day urlaub"></td>
                    <td class="day urlaub"></td>
                    <td class="day urlaub"></td>
                    <td class="soll">6</td>
                    <td class="ist">5</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Randig, Jan Niclas</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">0</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Alshaaer, Kawthar</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">3</td>
                </tr>
            </table>
            <table id="table2">
                <tr class="table-head">
                    <th class="date">Date</th>
                    <th class="day">Montag</th>
                    <th class="day">Dienstag</th>
                    <th class="day">Mittwoch</th>
                    <th class="day">Donnerstag</th>
                    <th class="day">Freitag</th>
                    <th class="day">Samstag</th>
                    <th class="day">Sonntag</th>
                    <th class="soll">Soll</th>
                    <th class="ist">Ist</th>
                </tr>
                <tr>
                    <td class="mitarbeiter">Nitsch, Simon</td>
                    <td class="day"></td>
                    <td class="day frei"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">4</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Alipkina, Denis</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day urlaub"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">5</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Randig, Jan Niclas</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">0</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Alshaaer, Kawthar</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">3</td>

                </tr>
            </table>
            <table id="table3">
                <tr class="table-head">
                    <th class="date">Date</th>
                    <th class="day">Montag</th>
                    <th class="day">Dienstag</th>
                    <th class="day">Mittwoch</th>
                    <th class="day">Donnerstag</th>
                    <th class="day">Freitag</th>
                    <th class="day">Samstag</th>
                    <th class="day">Sonntag</th>
                    <th class="soll">Soll</th>
                    <th class="ist">Ist</th>
                </tr>
                <tr>
                    <td class="mitarbeiter">Nitsch, Simon</td>
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
                <tr>
                    <td class="mitarbeiter">Alipkina, Denis</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day urlaub"></td>
                    <td class="day urlaub"></td>
                    <td class="day urlaub"></td>
                    <td class="day urlaub"></td>
                    <td class="soll">6</td>
                    <td class="ist">5</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Randig, Jan Niclas</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">0</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Alshaaer, Kawthar</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">3</td>
                </tr>
            </table>
            <table id="table4">
                <tr class="table-head">
                    <th class="date">Date</th>
                    <th class="day">Montag</th>
                    <th class="day">Dienstag</th>
                    <th class="day">Mittwoch</th>
                    <th class="day">Donnerstag</th>
                    <th class="day">Freitag</th>
                    <th class="day">Samstag</th>
                    <th class="day">Sonntag</th>
                    <th class="soll">Soll</th>
                    <th class="ist">Ist</th>
                </tr>
                <tr>
                    <td class="mitarbeiter">Nitsch, Simon</td>
                    <td class="day"></td>
                    <td class="day frei"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">4</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Alipkina, Denis</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day urlaub"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">5</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Randig, Jan Niclas</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">0</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Alshaaer, Kawthar</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">3</td>
                </tr>
            </table>
            <table id="table5">
                <tr class="table-head">
                    <th class="date">Date</th>
                    <th class="day">Montag</th>
                    <th class="day">Dienstag</th>
                    <th class="day">Mittwoch</th>
                    <th class="day">Donnerstag</th>
                    <th class="day">Freitag</th>
                    <th class="day">Samstag</th>
                    <th class="day">Sonntag</th>
                    <th class="soll">Soll</th>
                    <th class="ist">Ist</th>
                </tr>
                <tr>
                    <td class="mitarbeiter">Nitsch, Simon</td>
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
                <tr>
                    <td class="mitarbeiter">Alipkina, Denis</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day urlaub"></td>
                    <td class="day urlaub"></td>
                    <td class="day urlaub"></td>
                    <td class="day urlaub"></td>
                    <td class="soll">6</td>
                    <td class="ist">5</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Randig, Jan Niclas</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">0</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Alshaaer, Kawthar</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">3</td>
                </tr>
            </table>
            <table id="table6">
                <tr class="table-head">
                    <th class="date">Date</th>
                    <th class="day">Montag</th>
                    <th class="day">Dienstag</th>
                    <th class="day">Mittwoch</th>
                    <th class="day">Donnerstag</th>
                    <th class="day">Freitag</th>
                    <th class="day">Samstag</th>
                    <th class="day">Sonntag</th>
                    <th class="soll">Soll</th>
                    <th class="ist">Ist</th>
                </tr>
                <tr>
                    <td class="mitarbeiter">Nitsch, Simon</td>
                    <td class="day"></td>
                    <td class="day frei"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">4</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Alipkina, Denis</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day urlaub"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">5</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Randig, Jan Niclas</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">0</td>
                </tr>
                <tr>
                    <td class="mitarbeiter">Alshaaer, Kawthar</td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="day"></td>
                    <td class="soll">6</td>
                    <td class="ist">3</td>
                </tr>
            </table>
        </div>
    </div>
</div>

</body>
</html>