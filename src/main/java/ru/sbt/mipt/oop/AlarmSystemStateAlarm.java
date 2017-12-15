package ru.sbt.mipt.oop;


public class AlarmSystemStateAlarm implements AlarmSystemStateInterface {

  private final AlarmSystem alarmSystem;

  AlarmSystemStateAlarm(AlarmSystem alarmSystem) {
    this.alarmSystem = alarmSystem;
  }

  @Override
  public AlarmSystemStateEnum getState() {
    return AlarmSystemStateEnum.ALARM;
  }

  @Override
  public void turn() {
  }

  @Override
  public void onEvent(SensorEvent sensorEvent) {
    if (sensorEvent.getType() == SensorEventType.ALARM_OFF) {
      AlarmSystemStateOff alarmSystemStateOff = new AlarmSystemStateOff(alarmSystem);
      alarmSystem.setAlarmSystemState(new AlarmSystemStatePassword(alarmSystem, alarmSystemStateOff));
    } else if(sensorEvent.getType() == SensorEventType.ALARM_ON) {
      AlarmSystemStateOn alarmSystemStateOn = new AlarmSystemStateOn(alarmSystem);
      alarmSystem.setAlarmSystemState(new AlarmSystemStatePassword(alarmSystem, alarmSystemStateOn));
    }
  }
}