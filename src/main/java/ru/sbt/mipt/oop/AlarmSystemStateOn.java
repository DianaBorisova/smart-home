package ru.sbt.mipt.oop;

/**
 * Created by Диана on 17.11.2017.
 */
public class AlarmSystemStateOn implements AlarmSystemStateInterface {

    private final AlarmSystem alarmSystem;

    public AlarmSystemStateOn(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.ON;
    }

    @Override
    public void turn() {
        alarmSystem.setAlarmSystemState(new AlarmSystemStatePassword(alarmSystem,
            new AlarmSystemStateOff(alarmSystem)));
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        if ( sensorEvent.getType() == SensorEventType.ALARM_ALARM) {
            alarmSystem.setAlarmSystemState(new AlarmSystemStateAlarm(alarmSystem));
        }
        else turn();
    }
}
