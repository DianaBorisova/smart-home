package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

/**
 * Created by Диана on 13.10.2017.
 */
public class LightSensor implements EventHandler {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
                for (Door door : room.getDoors()) {
                    if (door.getId().equals(event.getObjectId())) {
                        if (event.getType() != DOOR_OPEN) {
                            if (room.getName().equals("hall")) {
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
}
