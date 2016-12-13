package ua.in.MySmartHome.dao.device.modbus.rtu.impl;

import ua.in.MySmartHome.dao.device.modbus.Modbus;
import ua.in.MySmartHome.dao.device.modbus.AbstractModbusDao;
import ua.in.MySmartHome.model.ScaleData;
import ua.in.MySmartHome.model.Sensor;
import ua.in.MySmartHome.model.SensorData;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shevchenko on 21.11.2016.
 */
public class SensorModbusDao extends AbstractModbusDao<MbWrapper<Sensor>> {

    public SensorModbusDao(Modbus modbusImpl) {
        super(modbusImpl);
    }

    @Override
    public int getCountReg() {
        return 1;
    }

    @Override
    public MbWrapper<Sensor> parseResult(MbWrapper<Sensor> sensorMbWrapper, List<Integer> list) {
        Sensor sensor = sensorMbWrapper.getObject();
        SensorData sensorData = sensor.getSensorData();
        sensorData.setEng(list.get(0));
        sensorMbWrapper.getObject().setSensorData(sensorData);
        return sensorMbWrapper;
    }


}
