package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.List;


public class SensorEventObserver {

    private SmartHome smartHome;
    public List<EventHandler> handlers = new ArrayList<>();

    public SensorEventObserver(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    public void addHandlers() {
        handlers.add(new Decorator(new LightSensor()));
        handlers.add(new Decorator(new DoorSensor()));
        handlers.add(new Decorator(new HallLightSensor()));
        handlers.add(new Decorator(new AlarmSystemSensor()));
    }

    public void observe() {
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            handleEvent(event);
            System.out.println("Got event: " + event);
            event = getNextSensorEvent();
        }
    }

    public void handleEvent(SensorEvent event) {
        for (EventHandler eventHandler : handlers) {
            eventHandler.handleEvent(event);
        }
    }

    public void setHandlers(List<EventHandler> handlers) {
        this.handlers = handlers;
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }

}
