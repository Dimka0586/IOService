package ua.in.MySmartHome.dao.db.impl;

import ua.in.MySmartHome.dao.db.DaoFactory;
import ua.in.MySmartHome.dao.db.SensorJdbcDao;
import ua.in.MySmartHome.dao.db.VgdDataJdbcDao;
import ua.in.MySmartHome.dao.db.VgdJdbcDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by Shevchenko on 14.11.2016.
 */
public class MysqlDaoFactoryImpl implements DaoFactory {

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/ioservice";
    private String user="root";
    private String password="root";


    public MysqlDaoFactoryImpl(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public SensorJdbcDao getSensorDao(Connection connection) {
        return new SensorJdbcDaoImpl(connection);
    }

    @Override
    public SensorDataJdbcDaoImpl getSensorDataDao(Connection connection) {
        return new SensorDataJdbcDaoImpl(connection);
    }

    @Override
    public VgdJdbcDao getVgdDao(Connection connection) {
        return new VgdJdbcDaoImpl(connection);
    }

    @Override
    public VgdDataJdbcDao getVgdDataDao(Connection connection) {
        return new VgdDataJdbcDaoImpl(connection);
    }


}
