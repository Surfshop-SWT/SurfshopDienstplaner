package DAO;

import Model.Benutzer;
import Model.Kommentar;
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

    /**
     * Einfügen eines {@link Tag} in die Datenbank
     * @param entity
     * @return
     * @throws SQLException
     */
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

    /**
     * Liefert eine Liste von {@link Tag} für ein bestimmtes Jahr für einen {@link Benutzer}
     *
     * @param year
     * @param user
     * @return
     * @throws SQLException
     */
    public List<Tag> getDays(int year, Benutzer user) throws SQLException {
        String query = "SELECT tid, datum, tagart, benutzer_bid, kid, inhalt, tag_tid FROM tag " +
        "LEFT JOIN benutzer on benutzer.bid = tag.benutzer_bid " +
        "LEFT JOIN kommentar on kommentar.tag_tid = tag.tid " +
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
            if (rs.getInt("kid") != 0) {
                Kommentar kommentar = new Kommentar(tag);
                kommentar.setKid(rs.getInt("kid"));
                kommentar.setBenutzer(user);
                kommentar.setInhalt(rs.getString("inhalt"));
                kommentar.setTag(rs.getDate("datum"));
                tag.setKommentar(kommentar);
            }
            list.add(tag);
        }
        return list;
    }
}
