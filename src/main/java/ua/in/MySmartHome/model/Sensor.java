package ua.in.MySmartHome.model;

/**
 * Class of sensor automation system
 */
public class Sensor implements Equipment{

    /**Id of sensor*/
    private int id;

    /**Name of sensor*/
    private String name;

    /**Engineering value from device*/
    private int engValue;

    /**Real value from device*/
    private float value;

    public Sensor(String name){
        this.name = name;
    }

    public Sensor(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getEngValue(){
        return engValue;
    }

    public void setEngValue(int engValue){
        this.engValue = engValue;
    }

    public float getValue(){
        return value;
    }

    public void setValue(float value){
        this.value = value;
    }


}
