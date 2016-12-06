package ua.in.MySmartHome.dao.device.modbus;

import ua.in.MySmartHome.dao.device.modbus.rtu.impl.SensorModbusDao;

/**
 * Factory DAO's for working with modbus devices
 */
public interface DaoDeviceFactory {

    //Get dao object for working with Sensor
    public SensorModbusDao getSensorModbusDao();


}
