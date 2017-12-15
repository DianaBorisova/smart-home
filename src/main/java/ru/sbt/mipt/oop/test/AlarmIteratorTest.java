package ru.sbt.mipt.oop.test;

import org.junit.Test;
import ru.sbt.mipt.oop.AlarmIterator;
import ru.sbt.mipt.oop.AlarmSystem;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

import java.util.Collections;

import static org.junit.Assert.assertTrue;


public class AlarmIteratorTest {
    @Test
    public void doorIteratorTest() {
        SmartHome smartHome = new SmartHome();
        smartHome.addRoom(new Room(Collections.emptyList(),
            Collections.emptyList(), new AlarmSystem("1"),
            "room"));
        AlarmIterator alarmIterator = new AlarmIterator(smartHome);
        assertTrue(alarmIterator.hasNext());
    }
}
