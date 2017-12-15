package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LightIterator implements Iterator<Light> {

    private List<Room> roomList;
    private int roomPosition;
    private int lightPosition;

    public LightIterator(SmartHome smartHome) {
        roomList = new ArrayList<>(smartHome.getRooms());
    }

    @Override
    public boolean hasNext() {
        while (roomPosition < roomList.size()) {
            if (lightPosition < roomList.get(roomPosition).getLights().size()) {
                return true;
            } else {
                roomPosition++;
                lightPosition = 0;
            }
        }
        return false;
    }

    @Override
    public Light next() {
        if (hasNext()) {
            List<Light> doorList = new ArrayList<>(roomList.get(roomPosition).getLights());
            Light light = doorList.get(lightPosition);
            roomPosition++;
            lightPosition++;
            return light;
        } else {
            throw new NoSuchElementException("The End Of List Light");
        }
    }
}
