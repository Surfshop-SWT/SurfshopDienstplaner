## Wichtig
### Datenbank
Benutzername muss auch Primary Key sein
Table Benutzer Braucht noch Einträge für Arbeitszeit und die Benutzerrolle

###java
Benutzer Anlegen kann Daten jetzt in der Datenbank speichern.
DAO muss noch prüfen ob der Benutzername frei ist.

### Struktur
Order Struktur noch anpassen

### Ansicht
Bug das die normal Ansicht.css nicht genommen wird mit der Ansicht2.css geht es#
Ansicht wird zum Teil Dynamisch erstellt verbindung zu datenbank muss hergestellt werden IDEE JSONArray im Servlet und dann and die JS Datei übergeben

### Quicksave für MYSQL
select * from benutzer;
delete from benutzer where bid IN ();
ALTER TABLE benutzer AUTO_INCREMENT = 1;