package ru.sbt.mipt.oop.entities;

import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.entities.EntityType.*;

public class SmartHome implements Actionable {
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void executeAction(Class objectClass, Action action) {
        switch (objectClass.getName()) {
            case ROOM:
            case LIGHT:
            case DOOR:
                for (Room room : getRooms()) {
                    room.executeAction(objectClass, action);
                }
                break;
            case SMART_HOME:
                action.execute(this);
                break;
        }
    }
}
