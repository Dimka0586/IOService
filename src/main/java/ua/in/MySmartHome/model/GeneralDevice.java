package ua.in.MySmartHome.model;

/**
 * Created by Shevchenko on 21.11.2016.
 */
public class GeneralDevice {

    private int deviceAddress;
    private int startAddress;

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

    public void setStartAddress(int startAddress){
        this.startAddress = startAddress;
    }
}
