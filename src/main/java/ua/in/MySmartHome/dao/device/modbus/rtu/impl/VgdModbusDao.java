package ua.in.MySmartHome.dao.device.modbus.rtu.impl;

import ua.in.MySmartHome.dao.device.modbus.AbstractModbusDao;
import ua.in.MySmartHome.dao.device.modbus.Modbus;
import ua.in.MySmartHome.model.Vgd;
import ua.in.MySmartHome.model.VgdData;

import java.util.List;

/**
 * Created by Shevchenko on 11.12.2016.
 */
public class VgdModbusDao extends AbstractModbusDao<MbWrapper<Vgd>> {

    public VgdModbusDao(Modbus modbusImpl) {
        super(modbusImpl);
    }

    @Override
    public int getCountReg() {
        return 0;
    }

    @Override
    public MbWrapper<Vgd> parseResult(MbWrapper<Vgd> vgdMbWrapper, List<Integer> list) {
        Vgd vgd = vgdMbWrapper.getObject();
        VgdData vgdData = vgd.getLastVgdData();
        //sensorData.setEng(list.get(0));
        vgdMbWrapper.getObject().setLastVgdData(vgdData);
        return vgdMbWrapper;
    }
}
