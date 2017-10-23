package ru.sbt.mipt.oop;

/**
 * Created by Диана on 24.10.2017.
 */
public class Decorator implements EventHandler {
    private EventHandler eventHandler;

    public Decorator(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event){
        long start = System.currentTimeMillis();
        eventHandler.processEvent(smartHome, event);
        long end = System.currentTimeMillis();
        System.out.println("Exec time =" + (end-start) + "ms");
    }
}
