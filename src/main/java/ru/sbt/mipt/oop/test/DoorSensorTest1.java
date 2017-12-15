package ru.sbt.mipt.oop.test;


import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

/**
 * Created by Диана on 18.10.2017.
 */
public class DoorSensorTest1 {
    @Test
    public void handle() throws Exception {
        DoorSensor doorSensor = new DoorSensor();
        SmartHome smartHome = new SmartHome();
        String doorId = "1";
        Door door = new Door(doorId,false);
        smartHome.addRoom(new Room(Collections.emptyList(),
                Arrays.asList(door), new AlarmSystem("1"),
                "room"));
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, doorId);
        doorSensor.handleEvent(event);
        assertTrue(door.isOpen());
    }
}
