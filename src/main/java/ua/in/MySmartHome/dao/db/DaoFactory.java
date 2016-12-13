package ua.in.MySmartHome.dao.db;

import ua.in.MySmartHome.dao.db.impl.SensorDataJdbcDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Factory DAO's for working with db
 */
public interface DaoFactory{

    /**Create and return new connection to db*/
    public Connection getConnection() throws SQLException;

    //public GenericDao getDao(Connection connection, Class daoClass);
    public SensorJdbcDao getSensorDao(Connection connection);

    //public GenericDao getDao(Connection connection, Class daoClass);
    public SensorDataJdbcDaoImpl getSensorDataDao(Connection connection);

    public VgdJdbcDao getVgdDao(Connection connection);

    public VgdDataJdbcDao getVgdDataDao(Connection connection);


}
