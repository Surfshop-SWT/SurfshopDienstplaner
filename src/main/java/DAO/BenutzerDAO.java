package DAO;

import Model.Benutzer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 24.12.2020
 */
public class BenutzerDAO implements DAO<Benutzer> {

    /**
     *  Einfügen eines Neuen Users in die Datenbank
     *
     * @param entity der Benutzer
     * @return  neu erstellte Benutzer
     * @throws SQLException
     */
    @Override
    public Benutzer save(Benutzer entity) throws SQLException {
        String query = "insert into benutzer(vorname, nachname, emailadresse, telefonnummer, urlaubstage, benutzername, passwort)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        ps.setString(1, entity.getVorname());
        ps.setString(2, entity.getNachname());
        ps.setString(3, entity.getEMailadresse());
        ps.setString(4, entity.getTelefonnummer());
        ps.setInt(5, entity.getUrlaubstage());
        ps.setString(6, entity.getBenutzername());
        ps.setString(7, entity.getPasswort());
        ps.executeUpdate();
        return entity;
    }

    /**
     * Updated Einträge für den Benutzer in der Datenbank
     *
     * @param entity der Benutzer
     * @throws SQLException
     */
    @Override
    public void update(Benutzer entity) throws SQLException {
        String query = "update benutzer set benutzername=?, nachname=?, emailadresse=?, telefonnummer=?, urlaubstage=?, " +
                "benutzername=?, passwort=?";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        ps.setString(1, entity.getVorname());
        ps.setString(2, entity.getNachname());
        ps.setString(3, entity.getEMailadresse());
        ps.setString(4, entity.getTelefonnummer());
        ps.setInt(5, entity.getUrlaubstage());
        ps.setString(6, entity.getBenutzername());
        ps.setString(7, entity.getPasswort());
        ps.executeUpdate();
    }

    /**
     * Liefert uns einen User aus der Datenbank, anhand der ID
     *
     * @param id Benutzer ID
     * @return Benutzer
     * @throws SQLException
     */
    @Override
    public Benutzer getById(int id) throws SQLException {
        String query = "select * from benutzer where bid =?";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        Benutzer user = new Benutzer();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            user.setBid(rs.getInt("bid"));
            user.setVorname(rs.getString("vorname"));
            user.setNachname(rs.getString("nachname"));
            user.setEMailadresse(rs.getString("emailadresse"));
            user.setTelefonnummer(rs.getString("telefonnummer"));
            user.setUrlaubstage(rs.getInt("urlaubstage"));
            user.setBenutzername(rs.getString("benutzername"));
            user.setPasswort(rs.getString("passwort"));
        }

        if (check) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * Löscht einen Benutzer Eintrag in der Datenbank
     *
     * @param entity der Benutzer
     * @throws SQLException
     */
    @Override
    public void delete(Benutzer entity) throws SQLException {
        String query = "delete from benutzer where bid =?";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        ps.setInt(1, entity.getBid());
        ps.executeUpdate();
    }

    /**
     * Prüft ob der Benutzername bereits vergeben ist oder nicht
     *
     * @param benutzername
     * @return true oder false
     */
    public boolean existsByName(String benutzername) throws SQLException {
        return false;
    }

    public List<Benutzer> getAllBenutzer() throws SQLException {
        String query = "select * from benutzer";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Benutzer> list = new ArrayList<>();

        while(rs.next()) {
            Benutzer user = new Benutzer();
            user.setBid(rs.getInt("bid"));
            user.setVorname(rs.getString("vorname"));
            user.setNachname(rs.getString("nachname"));
            user.setEMailadresse(rs.getString("emailadresse"));
            user.setTelefonnummer(rs.getString("telefonnummer"));
            user.setUrlaubstage(rs.getInt("urlaubstage"));
            user.setBenutzername(rs.getString("benutzername"));
            user.setPasswort(rs.getString("passwort"));
        }
        return list;
    }
}
