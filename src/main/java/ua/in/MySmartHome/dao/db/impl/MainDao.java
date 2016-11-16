package ua.in.MySmartHome.dao.db.impl;

import ua.in.MySmartHome.dao.db.DaoFactory;
import ua.in.MySmartHome.dao.db.GenericDao;
import ua.in.MySmartHome.model.Sensor;

import java.sql.SQLException;

/**
 * Created by Shevchenko on 14.11.2016.
 */
public class MainDao {
    public static void main(String[] args) throws SQLException{
        DaoFactory mysqlDaoFactory = new MysqlDaoFactoryImpl();
        GenericDao sensorDao = mysqlDaoFactory.getSensorDao(mysqlDaoFactory.getConnection());
        sensorDao.create(new Sensor("sensor1"));
        System.out.println("readById : ");
        System.out.println(sensorDao.readById(1));
        Sensor sensor1 = (Sensor)sensorDao.readById(1);
        sensor1.setName("sensor1_1");
        sensorDao.update(sensor1);
        sensorDao.delete(sensor1);
    }
}
