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
    public void handleEvent(SensorEvent event){
        long start = System.currentTimeMillis();
        eventHandler.handleEvent(event);
        long end = System.currentTimeMillis();
        System.out.println("Exec time =" + (end-start) + "ms");
    }
}
