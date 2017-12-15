package ru.sbt.mipt.oop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorSensor implements EventHandler {
    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == DOOR_OPEN && event.getType() == DOOR_CLOSED) {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
            DoorIterator doorIterator = (DoorIterator) ctx.getBean("doorIterator");
            while (doorIterator.hasNext()) {
                Door door = doorIterator.next();
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        door.setOpen(true);
                        SensorCommand command = new SensorCommand(CommandType.DOOR_OPEN,
                            door.getId());
                        Application.sendCommand(command);
                    } else {
                        door.setOpen(false);
                        SensorCommand command = new SensorCommand(CommandType.DOOR_CLOSED,
                            door.getId());
                        Application.sendCommand(command);
                    }
                }
            }
        }
    }
}
