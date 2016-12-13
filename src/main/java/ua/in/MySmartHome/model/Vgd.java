package ua.in.MySmartHome.model;

/**
 * Created by Shevchenko on 10.12.2016.
 */
public class Vgd{

    private int id;
    private String name;
    private VgdData lastVgdData;

    public Vgd(){}

    public Vgd(String name){
        this.name = name;
    }

    public Vgd(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public VgdData getLastVgdData() {
        return lastVgdData;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastVgdData(VgdData lastVgdData) {
        this.lastVgdData = lastVgdData;
    }

    @Override
    public String toString() {
        return this.getClass() + "[id=" + id + ", name=" + name + ", vgdData=" + getLastVgdData()+"]";
    }
}
