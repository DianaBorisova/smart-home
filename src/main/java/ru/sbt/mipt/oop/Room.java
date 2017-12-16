package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;
    private AlarmSystem alarmSystem;

    public Room(Collection<Light> lights, Collection<Door> doors, AlarmSystem alarmSystem, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
        this.alarmSystem = alarmSystem;
    }

    public AlarmSystem getAlarmSystem() {
        return alarmSystem;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void executeAction(Action action) {
        for (Door door: doors) {
            door.executeAction(action);
        }
        for (Light light: lights) {
            light.executeAction(action);
        }
        if (alarmSystem != null) {
            alarmSystem.executeAction(action);
        }
        action.execute(this);
    }
}
