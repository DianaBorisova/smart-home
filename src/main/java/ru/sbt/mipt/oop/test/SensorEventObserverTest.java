package ru.sbt.mipt.oop.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import ru.sbt.mipt.oop.AlarmSystemSensor;
import ru.sbt.mipt.oop.DoorSensor;
import ru.sbt.mipt.oop.LightSensor;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventObserver;
import ru.sbt.mipt.oop.SmartHome;

public class SensorEventObserverTest {
    @Test
    public void test() {
        SmartHome smartHome = mock(SmartHome.class);
        LightSensor lightSensor = mock(LightSensor.class);
        DoorSensor doorSensor = mock(DoorSensor.class);
        AlarmSystemSensor alarmSystemSensor = mock(AlarmSystemSensor.class);


        SensorEventObserver sensorEventObserver = new SensorEventObserver(smartHome);
        SensorEvent sensorEvent = mock(SensorEvent.class);
        sensorEventObserver.handleEvent(sensorEvent);

        verify(lightSensor).handleEvent(sensorEvent);
        verify(doorSensor).handleEvent(sensorEvent);
        verify(alarmSystemSensor).handleEvent(sensorEvent);
    }
}