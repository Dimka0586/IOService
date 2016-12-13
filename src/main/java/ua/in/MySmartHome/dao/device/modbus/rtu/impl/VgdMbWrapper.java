package ua.in.MySmartHome.dao.device.modbus.rtu.impl;

import ua.in.MySmartHome.model.Vgd;
import ua.in.MySmartHome.model.VgdData;

/**
 * Created by shevchenko on 12.12.2016.
 */
public class VgdMbWrapper extends MbWrapper<Vgd>{


    public VgdMbWrapper(Vgd vgd){
        super(vgd);
    }

    public VgdMbWrapper(int deviceAddress, int startAddress, Vgd vgd){
        super(deviceAddress, startAddress, vgd);
        setWritingReg();
    }

    @Override
    public void setWritingReg() {
        if (getObject().getLastVgdData().isOpen()){
            writingReg = writingReg | (1 << 0);
        }else{
            writingReg = writingReg & ~(1 << 0);
        }

    }
}
