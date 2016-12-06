package ua.in.MySmartHome.dao.device.modbus.rtu.impl;

import ua.in.MySmartHome.dao.db.DaoFactory;
import ua.in.MySmartHome.dao.db.GenericDao;
import ua.in.MySmartHome.dao.db.impl.MysqlDaoFactoryImpl;
import ua.in.MySmartHome.dao.device.modbus.DaoDeviceFactory;
import ua.in.MySmartHome.model.ScaleData;
import ua.in.MySmartHome.model.Sensor;



import java.sql.SQLException;
import java.util.List;

/**
 * Created by Shevchenko on 21.11.2016.
 */
public class MainPlcDao {
    public static void main(String[] args) throws SQLException{
        DaoFactory mysqlDaoFactory = new MysqlDaoFactoryImpl();
        DaoDeviceFactory modbusDaoFactory = new ModbusDaoFactoryImpl();

        GenericDao sensorDao = mysqlDaoFactory.getSensorDao(mysqlDaoFactory.getConnection());

        Sensor sensor = (Sensor)sensorDao.readById(2);
        sensor.setScaleData(new ScaleData(0, 10000, -50.0f, 150.0f));

        MbWrapper<Sensor> sensorMbWrapper = new MbWrapper<Sensor>(1, 0, sensor);

        SensorModbusDao sensorModbusDao = modbusDaoFactory.getSensorModbusDao();
        for (int i = 0; i < 20; i++) {
            sensorMbWrapper = sensorModbusDao.read(sensorMbWrapper);
            System.out.print(sensorMbWrapper.getObject().getName() + " = ");
            System.out.println(sensorMbWrapper.getObject().getScaleData().getOut());
            sensorDao.create(sensorMbWrapper.getObject());
        }



    }
}
