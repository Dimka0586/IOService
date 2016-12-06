package ua.in.MySmartHome.dao.device.modbus.rtu.impl;

import ua.in.MySmartHome.dao.device.modbus.DaoDeviceFactory;

/**
 * Created by Shevchenko on 21.11.2016.
 */
public class ModbusDaoFactoryImpl implements DaoDeviceFactory {
    static final String PORT_WIN = "COM9";
    static final String PORT_UBUNTU = "/dev/ttyUSB0";
    static final int BAUD_RATE = 9600;
    static final int DATA_BITS = 8;
    static final String PARITY = "None";
    static final int STOP_BITS = 1;
    static final String ENCODING = "rtu";
    static final boolean ECHO = false;


    @Override
    public SensorModbusDao getSensorModbusDao() {
        return new SensorModbusDao(new J2modModbusRtuImpl(PORT_WIN, BAUD_RATE, DATA_BITS, PARITY,
                STOP_BITS, ENCODING, ECHO));
    }
}
