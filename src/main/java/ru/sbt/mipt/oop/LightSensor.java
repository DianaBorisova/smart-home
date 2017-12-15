package ru.sbt.mipt.oop;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LightSensor implements EventHandler {
    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == SensorEventType.LIGHT_ON || event.getType() == SensorEventType.LIGHT_OFF){
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
            LightIterator lightIterator = (LightIterator) ctx.getBean("lightIterator");
            while (lightIterator.hasNext()) {
                Light light = lightIterator.next();
                if (event.getObjectId().equals(light.getId())) {
                    if (event.getType() == SensorEventType.LIGHT_ON) {
                        light.setOn(true);
                        SensorCommand command = new SensorCommand(CommandType.LIGHT_ON,
                            light.getId());
                        Application.sendCommand(command);
                    } else {
                        light.setOn(true);
                        SensorCommand command = new SensorCommand(CommandType.LIGHT_ON,
                            light.getId());
                        Application.sendCommand(command);
                    }
                }
            }
        }
    }
}
