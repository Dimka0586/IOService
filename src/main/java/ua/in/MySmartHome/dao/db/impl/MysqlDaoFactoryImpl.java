package ua.in.MySmartHome.dao.db.impl;

import ua.in.MySmartHome.dao.db.DaoCreator;
import ua.in.MySmartHome.dao.db.DaoFactory;
import ua.in.MySmartHome.dao.db.GenericDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shevchenko on 14.11.2016.
 */
public class MysqlDaoFactoryImpl implements DaoFactory {

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/ioservice";
    private String user="root";
    private String password="root";
    private Map<Class, DaoCreator> creators;

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
    public GenericDao getSensorDao(Connection connection) {
        return new SensorDao(connection);
    }



}
