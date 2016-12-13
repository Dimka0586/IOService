package ua.in.MySmartHome.model;

/**
 * Created by Shevchenko on 21.11.2016.
 */
public abstract class GeneralDevice {

    private int deviceAddress;
    private int startAddress;
    protected int writingReg;

    public GeneralDevice(){

    }

    public GeneralDevice(int deviceAddress, int startAddress){
        this.deviceAddress = deviceAddress;
        this.startAddress = startAddress;
    }

    public int getUnitAddress(){
        return deviceAddress;
    }

    public void setUnitAddress(int deviceAddress){
        this.deviceAddress = deviceAddress;
    }

    public int getStartAddress(){
        return startAddress;
    }

    public int getDeviceAddress() {
        return deviceAddress;
    }

    public int getWritingReg() {
        setWritingReg();
        return writingReg;
    }

    public void setStartAddress(int startAddress){
        this.startAddress = startAddress;
    }

    public abstract void setWritingReg();
}
