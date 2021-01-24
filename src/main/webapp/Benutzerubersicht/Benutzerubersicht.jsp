<%--
  Created by IntelliJ IDEA.
  User: Tim Lueneburg
  Date: 12.01.2021
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Benutzerübersicht</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<link href="${pageContext.request.contextPath}/Benutzerubersicht/Benutzerubersicht1.css"
      rel="stylesheet" type="text/css">
<body>

<div class="header d-none d-md-block">
    <form action="${pageContext.request.contextPath}/ansicht" method="get">
        <div class="arbeitsplan"><input class="knopf" name="selectmonth" type="submit" value="ARBEITSPLANANSICHT"></div>
    </form>
    <div class="benutzer"><input class="knopf  choosen" type="submit" value="BENUTZERÜBERSICHT"></div>
    <div class="benutzerkonto"><input class="knopf" type="submit" value="BENUTZERKONTO"></div>
    <form action="${pageContext.request.contextPath}/logout" method="get">
        <div class="logout"><input class="knopf"  type="submit" value="ABMELDEN"></div>
    </form>
</div>
<div class="container-fluid mt-2">
    <div class="row">
        <div class="col d-md-none">
            <p>Machen Sie bitte diesem Bildschirm großer</p>
        </div>
        <div class="col-lg-2 col-md-12 d-none d-md-block">
            <form action="${pageContext.request.contextPath}/benutzerubersicht" method="post">
                <button id="benutzerAnlegen" type="submit" name="submit" class="button">neuen Benutzer anlegen</button>
            </form>
        </div>
        <div class="col-lg 10 col-md-12 d-none d-md-block">
            <div class="table">
                <table>
                    <tr>
                        <th class="vorname">Vorname</th>
                        <th class="nachname">Nachname</th>
                        <th class="benutzername">Benutzername</th>
                        <th class="email">Email</th>
                        <th class="telefonnummer">Telefonnummer</th>
                        <th class="urlaub">Urlaubstage</th>
                        <th class="arbeitszeit">Arbeitszeit</th>
                        <th class="rolle">Rolle</th>
                    </tr>
                    <c:forEach var="user" items="${benutzer}">
                        <tr>
                            <td>${user.getVorname()}</td>
                            <td>${user.getNachname()}</td>
                            <td>${user.getBenutzername()}</td>
                            <td>${user.getEMailadresse()}</td>
                            <td>${user.getTelefonnummer()}</td>
                            <td>${user.getUrlaubstage()}</td>
                            <td>${user.getArbeitszeit()}</td>
                            <td>${user.getRolle()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
    </div>
</div>
<!--Bootstrap JS CDN-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>
