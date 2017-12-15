package ru.sbt.mipt.oop.test;


import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Диана on 18.10.2017.
 */
public class HallLightSensorTest2 {
        @Test
        public void handle() throws Exception {
        HallLightSensor hallLightSensor = new HallLightSensor();
        LightSensor lightSensor = new LightSensor();
        SmartHome smartHome = new SmartHome();
        String lightId1 = "1";
        String lightId2 = "1";
        String doorId = "1";
        Light light1 = new Light(lightId1, true);
        Light light2 = new Light(lightId2, false);
        Door door = new Door(doorId, true);
        smartHome.addRoom(new Room(Arrays.asList(light1, light2),
                Arrays.asList(door),new AlarmSystem("1"),
                "hall"));
        lightSensor.handleEvent(new SensorEvent(SensorEventType.LIGHT_ON, lightId1));
        lightSensor.handleEvent(new SensorEvent(SensorEventType.LIGHT_ON, lightId2));
        hallLightSensor.handleEvent(new SensorEvent(SensorEventType.DOOR_CLOSED, doorId));
        assertFalse(light1.isOn());
        assertFalse(light2.isOn());
        assertFalse(door.isOpen());
        hallLightSensor.handleEvent(new SensorEvent(SensorEventType.DOOR_OPEN, doorId));
        assertTrue(door.isOpen());
        assertFalse(light2.isOn());

    }
}
