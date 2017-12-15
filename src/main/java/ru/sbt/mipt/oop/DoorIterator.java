package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class DoorIterator implements Iterator<Door> {

    private List<Room> roomList;
    private int roomPosition;
    private int doorPosition;

    public DoorIterator(SmartHome smartHome) {
        roomList = new ArrayList<>(smartHome.getRooms());
    }

    @Override
    public boolean hasNext() {
        while (roomPosition < roomList.size()) {
            if (doorPosition < roomList.get(roomPosition).getDoors().size()) {
                return true;
            } else {
                roomPosition++;
                doorPosition = 0;
            }
        }
        return false;
    }

    @Override
    public Door next() {
        if (hasNext()) {
            List<Door> doorList = new ArrayList<>(roomList.get(roomPosition).getDoors());
            Door door = doorList.get(doorPosition);
            roomPosition++;
            doorPosition++;
            return door;
        } else {
            throw new NoSuchElementException("The End Of List Door");
        }
    }


    public Room getCurrentRoom() {
        if (roomPosition < roomList.size()) return roomList.get(roomPosition);
        else return null;
    }
}
