package DAO;

import Model.Tag;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 14.01.2021
 */
public class TagDAO implements DAO<Tag> {

    @Override
    public Tag save(Tag entity) throws SQLException {
        String query = "insert into tag(datum, tagart, benutzer_bid)" +
                " VALUES (?, ?, ?)";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        ps.setDate(1, entity.getDatum());
        ps.setString(2, entity.getArt().toString());
        ps.setInt(3, entity.getBenutzer().getBid());
        ps.executeUpdate();
        return entity;
    }

    @Override
    public void update(Tag entity) throws SQLException {

    }

    @Override
    public Tag getById(int id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Tag entity) throws SQLException {

    }
}
