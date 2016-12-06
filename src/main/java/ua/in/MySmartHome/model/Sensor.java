package ua.in.MySmartHome.model;

/**
 * Created by shevchenko on 05.12.2016.
 */
public class Sensor{
    private int id;
    private String name;
    private ScaleData scaleData;


    public Sensor(){

    }

    public Sensor(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Sensor(int engMin, int engMax, float outMin, float outMax){
        scaleData = new ScaleData(engMin, engMax, outMin, outMax);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ScaleData getScaleData() {
        return scaleData;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScaleData(ScaleData scaleData) {
        this.scaleData = scaleData;
    }

}
