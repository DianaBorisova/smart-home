package ru.sbt.mipt.oop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HallLightSensor implements EventHandler {
    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType().equals(SensorEventType.DOOR_CLOSED)) {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
            DoorIterator doorIterator = (DoorIterator) ctx.getBean("doorIterator");
            while (doorIterator.hasNext()){
                Door door = doorIterator.next();
                if (door.getId().equals(event.getObjectId())) {
                    door.setOpen(false);
                    if (doorIterator.getCurrentRoom().getName().equals("hall")) {
                        SmartHome smartHome = (SmartHome) ctx.getBean("smartHome");
                        for (Room homeRoom : smartHome.getRooms()) {
                            for (Light light : homeRoom.getLights()) {
                                light.setOn(false);
                                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                                Application.sendCommand(command);
                            }
                        }
                    }
                }
            }
        }
    }
}
