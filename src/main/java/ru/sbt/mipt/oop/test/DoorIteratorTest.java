package ru.sbt.mipt.oop.test;

import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertFalse;


public class DoorIteratorTest {
    @Test
    public void doorIteratorTest() {
        SmartHome smartHome = new SmartHome();
        String doorId1 = "1";
        String doorId2 = "2";
        Door door1 = new Door(doorId1,true);
        Door door2 = new Door(doorId2,false);
        smartHome.addRoom(new Room(Collections.emptyList(),
            Arrays.asList(door1, door2), new AlarmSystem("1"),
            "room"));
        DoorIterator doorIterator = new DoorIterator(smartHome);
        doorIterator.next();
        doorIterator.next();
        assertFalse(doorIterator.hasNext());
    }

}
