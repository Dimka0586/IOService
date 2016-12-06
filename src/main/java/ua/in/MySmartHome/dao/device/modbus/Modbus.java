package ua.in.MySmartHome.dao.device.modbus;

import java.util.List;

/**
 * Created by Shevchenko on 21.11.2016.
 */
public interface Modbus {
    public boolean readDiscInput(int unitId, int ref, byte num);
    public void writeCoil(int unitId, int ref, byte num, boolean val);
    public List<Integer> readInputReg(int unitId, int ref, int count);
    public void writeHoldingReg(int unitId, int ref, int val);
}
