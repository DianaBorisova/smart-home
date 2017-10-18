package ru.sbt.mipt.oop.test;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LightSensorTest {
    @Test
    public void handle() throws Exception {
        LightSensor lightSensor = new LightSensor();
            SmartHome home = new SmartHome();
        String lightId = "1";
        Light light = new Light(lightId, false);
        home.addRoom(new Room(Arrays.asList(light),
                Collections.emptyList(),
                "room"));
    SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, lightId);
    lightSensor.processEvent(home,event);
    assertTrue(light.isOn());
    }

}