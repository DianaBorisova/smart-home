package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class  Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        SmartHome smartHome = HomeJsonFileReader.read();
        // начинаем цикл обработки событий
        SensorEvent event = getNextSensorEvent();
        Collection<EventHandler> eventHandlers = configureHandlers();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler eventHandler : eventHandlers) {
                   eventHandler.processEvent(smartHome, event);
             }
            event = getNextSensorEvent();
        }
    }
    private static Collection<EventHandler> configureHandlers () {
        Collection<EventHandler> eventHandlers = new ArrayList<>();
        eventHandlers.add(new Decorator(new LightSensor()));
        eventHandlers.add(new Decorator(new DoorSensor()));
        eventHandlers.add(new Decorator(new HallLightSensor()));
        return eventHandlers;
    }
    static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
