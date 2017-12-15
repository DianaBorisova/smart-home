package ru.sbt.mipt.oop.test;

import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertFalse;


public class LightIteratorTest {

    @Test
    public void doorIteratorTest() {
        SmartHome smartHome = new SmartHome();
        String lightId = "1";
        Light light1 = new Light(lightId, true);
        Light light2 = new Light(lightId, true);
        Light light3 = new Light(lightId, true);
        smartHome.addRoom(new Room(Arrays.asList(light1, light2, light3),
            Collections.emptyList(),new AlarmSystem("1"),
            "room"));
        LightIterator lightIterator = new LightIterator(smartHome);
        lightIterator.next();
        lightIterator.next();
        lightIterator.next();
        assertFalse(lightIterator.hasNext());
    }

}
