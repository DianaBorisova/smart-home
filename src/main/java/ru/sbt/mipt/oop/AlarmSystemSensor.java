package ru.sbt.mipt.oop;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AlarmSystemSensor implements EventHandler{

    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == SensorEventType.ALARM_ON || event.getType() == SensorEventType.ALARM_OFF ||
            event.getType() == SensorEventType.ALARM_ALARM || event.getType() == SensorEventType.PASSWORD_SET) {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
            AlarmIterator alarmIterator = (AlarmIterator) ctx.getBean("alarmIterator");
            while (alarmIterator.hasNext()) {
                AlarmSystem alarmSystem = alarmIterator.next();
                if (alarmSystem != null && alarmSystem.getId().equals(event.getObjectId())) {
                    alarmSystem.onEvent(event);
                }
            }
        }
    }
}
