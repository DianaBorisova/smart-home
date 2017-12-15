package ru.sbt.mipt.oop;


public class AlarmSystemStatePassword implements AlarmSystemStateInterface {

  private final AlarmSystem alarmSystem;
  private final AlarmSystemStateInterface futureState;


  public AlarmSystemStatePassword(AlarmSystem alarmSystem, AlarmSystemStateInterface futureState) {
    this.alarmSystem = alarmSystem;
    this.futureState = futureState;
  }

  @Override
  public AlarmSystemStateEnum getState() {
    return AlarmSystemStateEnum.WAIT_FOR_PASSWORD;
  }

  @Override
  public void turn() {
  }

  @Override
  public void onEvent(SensorEvent sensorEvent) {
    if (sensorEvent.getType() == SensorEventType.PASSWORD_SET) {
      alarmSystem.setAlarmSystemState(futureState);
    }
  }
}
