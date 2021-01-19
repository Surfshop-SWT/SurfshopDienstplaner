package DAO;

import Model.Kommentar;
import Model.Tag;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 06.01.2021
 */
public class KommentarDAO implements DAO<Kommentar>{

    @Override
    public Kommentar save(Kommentar entity) throws SQLException {
        String query = "insert into kommentar(inhalt, tag_tid)" +
                " VALUES (?, ?)";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        ps.setString(1, entity.getKontext());
        ps.setInt(2, entity.getTag_id());
        ps.executeUpdate();

        return entity;
    }

    @Override
    public void update(Kommentar entity) throws SQLException {

    }

    @Override
    public Kommentar getById(int id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Kommentar entity) throws SQLException {

    }

    public List<Kommentar> getKommentar(int year, Tag tag) throws SQLException {
        return null;
    }

}
