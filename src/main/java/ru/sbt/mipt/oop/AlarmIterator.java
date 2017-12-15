package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class AlarmIterator implements Iterator<AlarmSystem> {

    private List<Room> roomList;
    private int roomPosition;

    public AlarmIterator(SmartHome smartHome) {
        roomList = new ArrayList<>(smartHome.getRooms());
    }

    @Override
    public boolean hasNext() {
        while (roomPosition < roomList.size()) {
            if (roomList.get(roomPosition).getAlarmSystem() != null) {
                return true;
            } else {
                roomPosition++;
            }
        }
        return false;
    }

    @Override
    public AlarmSystem next() {
        if (hasNext()) {
            AlarmSystem alarmSystem = roomList.get(roomPosition).getAlarmSystem();
            roomPosition++;
            return alarmSystem;
        } else {
            throw new NoSuchElementException("The End Of List Alarm");
        }
    }
}
