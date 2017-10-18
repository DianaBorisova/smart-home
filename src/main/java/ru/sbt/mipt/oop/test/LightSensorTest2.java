package ru.sbt.mipt.oop.test;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Диана on 18.10.2017.
 */
public class LightSensorTest2 {
    @Test
    public void handle() throws Exception {
        LightSensor lightSensor = new LightSensor();
        SmartHome home = new SmartHome();
        String lightId = "1";
        Light light1 = new Light(lightId, true);
        Light light2 = new Light(lightId, true);
        Light light3 = new Light(lightId, true);
        home.addRoom(new Room(Arrays.asList(light1, light2, light3),
                Collections.emptyList(),
                "room"));
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, lightId);
        lightSensor.processEvent(home,event);
        assertFalse(light1.isOn());
        assertFalse(light2.isOn());
        assertFalse(light3.isOn());
        event = new SensorEvent(SensorEventType.LIGHT_ON, lightId);
        lightSensor.processEvent(home,event);
        assertTrue(light1.isOn());
        assertTrue(light2.isOn());
        assertTrue(light3.isOn());

    }
}
