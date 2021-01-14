package DAO;

import Model.Kommentar;

import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 06.01.2021
 */
public class KommentarDAO implements DAO<Kommentar>{

    @Override
    public Kommentar save(Kommentar entity) throws SQLException {
        return null;
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
}
