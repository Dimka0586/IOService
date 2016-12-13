package ua.in.MySmartHome.model;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by Shevchenko on 10.12.2016.
 */
public class VgdData {

    private int id;
    private int vgd_id;
    private byte stateBool;
    private boolean open;
    private boolean opened;
    private boolean closed;
    private Time timeOpen;
    private Time timeClose;
    private boolean alarmOpen;
    private boolean alarmClose;

    public VgdData(int vgd_id, boolean open, boolean opened, boolean closed,
                   Time timeOpen, Time timeClose, boolean alarmOpen, boolean alarmClose){
        this.vgd_id = vgd_id;
        this.open = open;
        this.opened = opened;
        this.closed = closed;
        this.timeOpen = timeOpen;
        this.timeClose = timeClose;
        this.alarmOpen = alarmOpen;
        this.alarmClose = alarmClose;
    }

    public VgdData(int id, int vgd_id, boolean open, boolean opened, boolean closed,
                   Time timeOpen, Time timeClose, boolean alarmOpen, boolean alarmClose){
        this.id = id;
        this.vgd_id = vgd_id;
        this.open = open;
        this.opened = opened;
        this.closed = closed;
        this.timeOpen = timeOpen;
        this.timeClose = timeClose;
        this.alarmOpen = alarmOpen;
        this.alarmClose = alarmClose;
    }

    public int getId() {
        return id;
    }

    public int getVgd_id() {

        return vgd_id;
    }

    public byte getStateBool() {

        return stateBool;
    }

    public boolean isOpen() {
        return open;
    }

    public boolean isOpened() {
        return opened;
    }

    public boolean isClosed() {
        return closed;
    }

    public Time getTimeOpen() {
        return timeOpen;
    }

    public Time getTimeClose() {
        return timeClose;
    }

    public boolean isAlarmOpen() {
        return alarmOpen;
    }

    public boolean isAlarmClose() {
        return alarmClose;
    }

    public void setVgd_id(int vgd_id) {
        this.vgd_id = vgd_id;
    }

    public void setStateBool(byte stateBool) {
        this.stateBool = stateBool;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public void setTimeOpen(Time timeOpen) {
        this.timeOpen = timeOpen;
    }

    public void setTimeClose(Time timeClose) {
        this.timeClose = timeClose;
    }

    public void setAlarmOpen(boolean alarmOpen) {
        this.alarmOpen = alarmOpen;
    }

    public void setAlarmClose(boolean alarmClose) {
        this.alarmClose = alarmClose;
    }

    @Override
    public String toString() {
        return this.getClass()+ "[id=" + id + ", vgd_id=" + vgd_id + ", open=" + open +
                ", opened=" + opened + ", closed=" + closed + ", timeOpen=" + timeOpen +
                ", timeClose=" + timeClose + ", alarmOpen=" + alarmOpen + ", alarmClose=" +
                alarmClose + "]";
    }
}
