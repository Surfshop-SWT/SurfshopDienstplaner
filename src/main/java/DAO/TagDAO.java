package DAO;

import Model.Benutzer;
import Model.Tag;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


    public List<Tag> getDays(int year, Benutzer user) throws SQLException {
        String query = "SELECT tid, datum, tagart, benutzer_bid FROM surfshop2.tag " +
                "JOIN surfshop2.benutzer on benutzer.bid = tag.benutzer_bid " +
                "WHERE YEAR(datum) =? and benutzer_bid=?";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        ps.setInt(1, year);
        ps.setInt(2, user.getBid());
        ResultSet rs = ps.executeQuery();
        List<Tag> list = new ArrayList<>();

        while (rs.next()) {
            Tag tag = new Tag();
            tag.setTid(rs.getInt("tid"));
            tag.setBenutzer(user);
            tag.setDatum(rs.getDate("datum"));
            tag.setArt(rs.getString("tagart"));
            list.add(tag);

        }
        return list;
    }
}
