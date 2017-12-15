package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room {
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
}
