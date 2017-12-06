package ru.sbt.mipt.oop.entities;

import static ru.sbt.mipt.oop.entities.EntityType.LIGHT;

public class Light implements Actionable {
    private final String id;
    private boolean isOn;
    private String roomName = "not stated";

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void executeAction(Class objectClass, Action action) {
        if (objectClass.getName().equals(LIGHT)) {
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
