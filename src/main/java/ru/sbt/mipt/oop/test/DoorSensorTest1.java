package ru.sbt.mipt.oop.test;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Диана on 18.10.2017.
 */
public class DoorSensorTest1 {
    @Test
    public void handle() throws Exception {
        DoorSensor doorSensor = new DoorSensor();
        SmartHome home = new SmartHome();
        String doorId = "1";
        Door door = new Door(doorId,false);
        home.addRoom(new Room(Collections.emptyList(),
                Arrays.asList(door),
                "room"));
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, doorId);
        doorSensor.processEvent(home, event);
        assertTrue(door.isOpen());
    }
}
