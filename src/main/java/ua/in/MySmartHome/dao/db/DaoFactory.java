package ua.in.MySmartHome.dao.db;

import ua.in.MySmartHome.dao.db.impl.SensorDao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Factory DAO's for working with db
 */
public interface DaoFactory{

    /**Create and return new connection to db*/
    public Connection getConnection() throws SQLException;

    //public GenericDao getDao(Connection connection, Class daoClass);
    public GenericDao getSensorDao(Connection connection);


}
