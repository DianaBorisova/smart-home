package ru.sbt.mipt.oop.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import ru.sbt.mipt.oop.AlarmSystem;
import ru.sbt.mipt.oop.AlarmSystemStateEnum;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;

public class AlarmSystemTest {
    private SensorEvent createSensorEvent() {
        return new SensorEvent(SensorEventType.DOOR_OPEN, "1");
    }
    @Test
    public void testNewSystemIsOff(){
        AlarmSystem alarmSystem = new AlarmSystem("1");
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void testNewSystemIsOn(){
        AlarmSystem alarmSystem = new AlarmSystem("1");
        alarmSystem.turn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getState());
    }

    @Test
    public void testSensorEventSetsWaitPasswordState(){
        AlarmSystem alarmSystem = new AlarmSystem("1");
        alarmSystem.turn();
        SensorEvent sensorEvent = createSensorEvent();
        alarmSystem.onEvent(sensorEvent);
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

    @Test
    public void  testOnEventWhenSystemIsOn(){
        AlarmSystem alarmSystem = new AlarmSystem("1");
        alarmSystem.onEvent(createSensorEvent());
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void testTurnOnDoesNotDoAnythingWhenSystemIsWaitingForPassword() {
        AlarmSystem alarmSystem = new AlarmSystem("1");
        alarmSystem.turn();
        alarmSystem.onEvent(createSensorEvent());
        alarmSystem.turn();
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }
}
