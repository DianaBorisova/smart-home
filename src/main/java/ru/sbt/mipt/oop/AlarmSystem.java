package ru.sbt.mipt.oop;

/**
 * Created by Диана on 17.11.2017.
 */
public class AlarmSystem implements AlarmSystemStateInterface {

    private final String id;

    private AlarmSystemStateInterface alarmSystemStateInterface;

    public AlarmSystem(String id ){
        this.id = id;
        alarmSystemStateInterface = new AlarmSystemStateOff(this);
    }

    public String getId() {
        return id;
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return alarmSystemStateInterface.getState();
    }

    @Override
    public void turn() {
        alarmSystemStateInterface.turn();
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        alarmSystemStateInterface.onEvent(sensorEvent);
    }

    void setAlarmSystemState(AlarmSystemStateInterface alarmSystemStateInterface) {
        this.alarmSystemStateInterface = alarmSystemStateInterface;
    }
}

