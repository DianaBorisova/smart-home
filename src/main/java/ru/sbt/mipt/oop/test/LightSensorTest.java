package ru.sbt.mipt.oop.test;


import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class LightSensorTest {
    @Test
    public void handle() throws Exception {
        LightSensor lightSensor = new LightSensor();
            SmartHome smartHome = new SmartHome();
        String lightId = "1";
        Light light = new Light(lightId, false);
        smartHome.addRoom(new Room(Arrays.asList(light),
                Collections.emptyList(), new AlarmSystem("1"),
                "room"));
    SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, lightId);
    lightSensor.handleEvent(event);
    assertTrue(light.isOn());
    }

}