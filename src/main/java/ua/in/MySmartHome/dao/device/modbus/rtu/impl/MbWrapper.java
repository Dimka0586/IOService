package ua.in.MySmartHome.dao.device.modbus.rtu.impl;

import ua.in.MySmartHome.model.GeneralDevice;

/**
 * Created by Shevchenko on 06.12.2016.
 */
public class MbWrapper<T> extends GeneralDevice {
    private T object;

    public MbWrapper(){

    }

    public MbWrapper(T object){
        this.object = object;
    }

    public MbWrapper(int deviceAddress, int startAddress, T object){
        super(deviceAddress, startAddress);
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
