package ua.in.MySmartHome.model;

/**
 * Created by shevchenko on 05.12.2016.
 */
public class ScaleData {
    int in;
    int inMin;
    int inMax;
    float out;
    float outMin;
    float outMax;

    public ScaleData(){

    }

    public ScaleData(int inMin, int inMax, float outMin, float outMax){
        this.inMin = inMin;
        this.inMax = inMax;
        this.outMin = outMin;
        this.outMax = outMax;
    }

    public int getEng(){
        return in;
    }

    public float getOut() {
        return (in - inMin)*(outMax - outMin)/(inMax - inMin)+outMin;
    }

    public float getOutMin() {
        return outMin;
    }

    public float getOutMax() {
        return outMax;
    }

    public int getEngMin() {
        return inMin;
    }

    public int getEngMax() {
        return inMax;
    }

    public void setEng(int in) {
        this.in = in;
    }

    public void setOut(float out) {
        this.out = out;
    }

    public void setOutMin(float outMin) {
        this.outMin = outMin;
    }

    public void setOutMax(float outMax) {
        this.outMax = outMax;
    }

    public void setEngMin(int inMin) {
        this.inMin = inMin;
    }

    public void setEngMax(int inMax) {
        this.inMax = inMax;
    }
}
