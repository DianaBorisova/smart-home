package ru.sbt.mipt.oop;

/**
 * Created by Диана on 17.11.2017.
 */
public interface AlarmSystemStateInterface {

    AlarmSystemStateEnum getState();

    void turn();

    void onEvent(SensorEvent sensorEvent);

}
