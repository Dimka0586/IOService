package ua.in.MySmartHome.dao.db;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface of control states object
 * @param <T> type of object
 */
public interface GenericDao<T> {

    /**Create new record by specified object*/
    public T create(T t) throws SQLException;

    /**Return object with specified id or null*/
    public T readById(int id) throws SQLException;

    /**Update record appropriate specified object*/
    public void update(T t) throws SQLException;

    /**Delete record appropriate specified object*/
    public void delete(T t) throws SQLException;

    /**Return all objects by T*/
    public List<T> readAll() throws SQLException;
}
