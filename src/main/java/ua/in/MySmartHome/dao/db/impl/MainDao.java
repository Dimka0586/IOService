package ua.in.MySmartHome.dao.db.impl;

import ua.in.MySmartHome.dao.db.*;
import ua.in.MySmartHome.dao.device.modbus.DaoDeviceFactory;
import ua.in.MySmartHome.dao.device.modbus.rtu.impl.*;
import ua.in.MySmartHome.model.Sensor;
import ua.in.MySmartHome.model.SensorData;
import ua.in.MySmartHome.model.Vgd;
import ua.in.MySmartHome.model.VgdData;


import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

/**
 * Created by Shevchenko on 14.11.2016.
 */
public class MainDao {
    public static void main(String[] args) throws SQLException, InterruptedException {
        DaoFactory mysqlDaoFactory = new MysqlDaoFactoryImpl();
        DaoDeviceFactory modbusFactory = new ModbusDaoFactoryImpl();
        SensorJdbcDao sensorDao = mysqlDaoFactory.getSensorDao(mysqlDaoFactory.getConnection());
        SensorDataJdbcDao sensorDataDao = mysqlDaoFactory.getSensorDataDao(mysqlDaoFactory.getConnection());
        SensorModbusDao sensorModbusDao = modbusFactory.getSensorModbusDao();


       /* for (int i = 0; i < 1; i++) {

            Sensor sensor1 = (Sensor) sensorDao.readById(3);
            SensorData sensorData1 = sensorDao.getLastSensorData(sensor1);
            sensorData1.setEngMax(10000);
            sensor1.setSensorData(sensorData1);

            //read from PLC
            MbWrapper<Sensor> sensorMbWrapper = new MbWrapper<Sensor>(1, 0, sensor1);
            sensor1 = sensorModbusDao.read(sensorMbWrapper).getObject();
            System.out.println(sensor1.getSensorData());
            sensorDataDao.create(sensor1.getSensorData());
        }*/


        ////create new vgd in db
        VgdJdbcDao vgdJdbcDao = mysqlDaoFactory.getVgdDao(mysqlDaoFactory.getConnection());
        VgdDataJdbcDao vgdDataJdbcDao = mysqlDaoFactory.getVgdDataDao(mysqlDaoFactory.getConnection());
        VgdModbusDao vgdModbusDao = modbusFactory.getVgdModbusDao();

        Vgd vgd1 = new Vgd("vgd1");
        //vgd1 = vgdJdbcDao.create(vgd1);
        vgd1 = vgdJdbcDao.readById(1);
        //System.out.println(vgd1);

        VgdData vgdData1 = new VgdData(vgd1.getId(), true, true, false, new Time(5), new Time(6), false, false);
        vgdData1 = vgdDataJdbcDao.create(vgdData1);

        //vgdData1 = vgdDataJdbcDao.readById(1);

        vgd1.setLastVgdData(vgdData1);
        System.out.println("isOpen = " + vgd1.getLastVgdData().isOpen());

        VgdMbWrapper vgdMbWrapper = new VgdMbWrapper(1, 5, vgd1);

        System.out.println(vgdMbWrapper.getUnitAddress() + " " + vgdMbWrapper.getStartAddress() + " "
                + vgdMbWrapper.getWritingReg());

        //vgd1.getLastVgdData().setOpen(false);
        VgdData vgdDataTest = vgdMbWrapper.getObject().getLastVgdData();
        for (int i = 0; i < 20; i++) {
            vgdDataTest.setOpen(!vgdMbWrapper.getObject().getLastVgdData().isOpen());
            vgd1.setLastVgdData(vgdDataTest);
            System.out.println("isOpen = " + vgd1.getLastVgdData().isOpen());
            vgdModbusDao.write(vgdMbWrapper);
        }


















    }
}
