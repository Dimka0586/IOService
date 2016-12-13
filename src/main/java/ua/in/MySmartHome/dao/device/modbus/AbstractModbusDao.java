package ua.in.MySmartHome.dao.device.modbus;

import ua.in.MySmartHome.dao.device.GenericDeviceDao;
import ua.in.MySmartHome.dao.device.modbus.Modbus;
import ua.in.MySmartHome.dao.device.modbus.rtu.impl.MbWrapper;
import ua.in.MySmartHome.model.GeneralDevice;

import java.util.List;

/**
 * Created by Shevchenko on 21.11.2016.
 */
public abstract class AbstractModbusDao<T extends GeneralDevice> implements GenericDeviceDao<T> {

    private Modbus modbusImpl;

    public AbstractModbusDao(Modbus modbusImpl){
        this.modbusImpl = modbusImpl;
    }

    public abstract int getCountReg();

    public abstract T parseResult(T t, List<Integer> list);

    @Override
    public T read(T t) {
        List<Integer> list = modbusImpl.readInputReg(t.getUnitAddress(), t.getStartAddress(), getCountReg());
        return parseResult(t, list);
    }

    @Override
    public void write(T t) {
        System.out.println("writingReg = " + t.getWritingReg());
        modbusImpl.writeReg(t.getUnitAddress(), t.getStartAddress(), t.getWritingReg());
    }
}
