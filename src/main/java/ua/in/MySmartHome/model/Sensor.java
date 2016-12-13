package ua.in.MySmartHome.model;

import java.util.List;

/**
 * Created by shevchenko on 05.12.2016.
 */
public class Sensor{
    private int id;
    private String name;
    private SensorData sensorData;


    public Sensor(){

    }

    public Sensor(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SensorData getSensorData() {
        return sensorData;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSensorData(SensorData sensorData) {
        this.sensorData = sensorData;
    }

}
