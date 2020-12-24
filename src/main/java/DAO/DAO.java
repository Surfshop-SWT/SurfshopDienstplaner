package DAO;

import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 24.12.2020
 */
public interface DAO<T> {

    T save(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    T getById(int id) throws SQLException;

    void delete(T entity) throws SQLException;
}
