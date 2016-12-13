package ua.in.MySmartHome.model;

import java.sql.Timestamp;

/**
 * Created by Shevchenko on 07.12.2016.
 */
public class SensorData extends ScaleData {
    int id;
    int sensor_id;
    Timestamp time;

    public SensorData(){

    }

    public SensorData(int inMin, int inMax, float outMin, float outMax){
        this.inMin = inMin;
        this.inMax = inMax;
        this.outMin = outMin;
        this.outMax = outMax;
    }

    public SensorData(int sensor_id, int in, int inMin, int inMax, float outMin, float outMax){
        this.sensor_id = sensor_id;
        this.in = in;
        this.inMin = inMin;
        this.inMax = inMax;
        this.outMin = outMin;
        this.outMax = outMax;
    }

    public SensorData(int id, int sensor_id, int in, int inMin, int inMax, float outMin, float outMax){
        this.id = id;
        this.sensor_id = sensor_id;
        this.in = in;
        this.inMin = inMin;
        this.inMax = inMax;
        this.outMin = outMin;
        this.outMax = outMax;
    }

    public int getId() {
        return id;
    }

    public Timestamp getTime() {
        return time;
    }

    public int getSensor_id() {

        return sensor_id;
    }

    public void setSensor_id(int sensor_id) {
        this.sensor_id = sensor_id;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return this.getClass() + "[id="+id+", sensor_id="+sensor_id+
                ", eng="+getEng()+", engMin="+getEngMin()+", engMax="+getEngMax()+
                ", r="+getOut()+", rMin="+getOutMin()+", rMax="+getOutMax()+"]";
    }
}
