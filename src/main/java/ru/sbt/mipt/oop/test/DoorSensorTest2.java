package ru.sbt.mipt.oop.test;


import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Диана on 18.10.2017.
 */
public class DoorSensorTest2 {
    @Test
    public void handle() throws Exception {
        DoorSensor doorSensor = new DoorSensor();
        SmartHome smartHome = new SmartHome();
        String doorId1 = "1";
        String doorId2 = "2";
        Door door1 = new Door(doorId1,true);
        Door door2 = new Door(doorId2,false);
        smartHome.addRoom(new Room(Collections.emptyList(),
                Arrays.asList(door1, door2), new AlarmSystem("1"),
                "room"));
        SensorEvent event1 = new SensorEvent(SensorEventType.DOOR_CLOSED, doorId1);
        SensorEvent event2 = new SensorEvent(SensorEventType.DOOR_CLOSED, doorId2);
        doorSensor.handleEvent(event1);
        doorSensor.handleEvent(event2);
        assertFalse(door1.isOpen());
        assertFalse(door2.isOpen());
        event2 = new SensorEvent(SensorEventType.DOOR_OPEN, doorId2);
        doorSensor.handleEvent(event2);
        assertTrue(door2.isOpen());
    }
}
