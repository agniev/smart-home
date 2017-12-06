package ru.sbt.mipt.oop.entities;

import static ru.sbt.mipt.oop.entities.EntityType.DOOR;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;
    private String roomName = "not stated";

    public Door(String id, boolean isOpen) {
        this.id = id;
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void executeAction(Class objectClass, Action action) {
        if (objectClass.getName().equals(DOOR)) {
            action.execute(this);
        }
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
