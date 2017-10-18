package ru.sbt.mipt.oop.test;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Created by Диана on 18.10.2017.
 */
public class HallLightSensorTest1 {

    @Test
    public void handle() throws Exception {
        HallLightSensor hallLightSensor = new HallLightSensor();
        LightSensor lightSensor = new LightSensor();
        DoorSensor doorSensor = new DoorSensor();
        SmartHome home = new SmartHome();
        String lightId1 = "1";
        String lightId2 = "1";
        String doorId = "1";
        Light light1 = new Light(lightId1, false);
        Light light2 = new Light(lightId2, false);
        Door door = new Door(doorId, false);
        home.addRoom(new Room(Arrays.asList(light1, light2),
                Arrays.asList(door),
                "hall"));
        lightSensor.processEvent(home, new SensorEvent(SensorEventType.LIGHT_ON, lightId1));
        lightSensor.processEvent(home, new SensorEvent(SensorEventType.LIGHT_ON, lightId2));
        doorSensor.processEvent(home, new SensorEvent(SensorEventType.DOOR_OPEN, doorId));
        hallLightSensor.processEvent(home, new SensorEvent(SensorEventType.DOOR_CLOSED, doorId));
        assertFalse(light1.isOn());
        assertFalse(light2.isOn());
        assertFalse(door.isOpen());
    }
}