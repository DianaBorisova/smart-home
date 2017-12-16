package ru.sbt.mipt.oop.test;

import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CompositorTest {

    @Test
    public void Test(){
        SmartHome smartHome = new SmartHome();
        String lightId1 = "1";
        String lightId2 = "1";
        String doorId = "1";
        Light light1 = new Light(lightId1, false);
        Light light2 = new Light(lightId2, false);
        Door door = new Door(doorId, false);
        AlarmSystem alarmSystem = new AlarmSystem("1");
        Room room = new Room(Arrays.asList(light1, light2),
            Arrays.asList(door), alarmSystem,
            "hall");
        smartHome.addRoom(room);
        List<Object> objectList = new ArrayList<>();
        smartHome.executeAction(object -> {
            objectList.add(object);
        });
        assertEquals(6, objectList.size());
    }
}
