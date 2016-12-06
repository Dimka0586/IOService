package ua.in.MySmartHome.dao.device.modbus.rtu.impl;

import com.ghgande.j2mod.modbus.ModbusException;
import com.ghgande.j2mod.modbus.io.ModbusSerialTransaction;
import com.ghgande.j2mod.modbus.msg.*;
import com.ghgande.j2mod.modbus.net.SerialConnection;
import com.ghgande.j2mod.modbus.procimg.SimpleRegister;
import com.ghgande.j2mod.modbus.util.SerialParameters;
import ua.in.MySmartHome.dao.device.modbus.Modbus;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation Serial Modbus RTU functions using J2mod library
 */
public class J2modModbusRtuImpl implements Modbus {

    private SerialParameters serialParameters = null;

    public J2modModbusRtuImpl(String port, int baudRate, int dataBits,
                              String parity, int stopBits, String encoding, boolean echo){
        serialParameters = new SerialParameters();
        serialParameters.setPortName(port);
        serialParameters.setBaudRate(baudRate);
        serialParameters.setDatabits(dataBits);
        serialParameters.setParity(parity);
        serialParameters.setStopbits(stopBits);
        serialParameters.setEncoding(encoding);
        serialParameters.setEcho(echo);
    }

    @Override
    public boolean readDiscInput(int unitId, int ref, byte num) {
        return false;
    }

    @Override
    public void writeCoil(int unitId, int ref, byte num, boolean val) {

    }

    @Override
    public List<Integer> readInputReg(int unitId, int ref, int count) {
        SerialConnection connection = getConnection();
        ReadInputRegistersRequest req = new ReadInputRegistersRequest(ref, count);
        req.setUnitID(unitId);
        req.setHeadless();
        ModbusSerialTransaction trans = new ModbusSerialTransaction(connection);
        trans.setRequest(req);
        try {
            trans.execute();
        } catch (ModbusException e) {
            e.printStackTrace();
        }
        ReadInputRegistersResponse resp = (ReadInputRegistersResponse) trans.getResponse();
        connection.close();
        return parseInputRegisterResponse(resp);
    }

    @Override
    public void writeHoldingReg(int unitId, int ref, int val) {
        SerialConnection connection = getConnection();
        ModbusRequest req = new WriteSingleRegisterRequest(ref, new SimpleRegister(val));
        req.setUnitID(unitId);
        ModbusSerialTransaction trans = trans = new ModbusSerialTransaction(connection);
        trans.setRequest(req);
        req.setHeadless();
        try {
            trans.execute();
        } catch (ModbusException e) {
            e.printStackTrace();
        }
        connection.close();
    }

    private SerialConnection getConnection(){
        SerialConnection connection = new SerialConnection(serialParameters);
        try {
            connection.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void closeConnection(SerialConnection connection){
        connection.close();
    }

    private List<Integer> parseInputRegisterResponse(ReadInputRegistersResponse resp){
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < resp.getWordCount(); i++){
            list.add(i, resp.getRegisterValue(i));
        }
        return list;
    }
}
