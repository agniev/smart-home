package ru.sbt.mipt.oop.sensors.handlers;

import ru.sbt.mipt.oop.events.Event;
import ru.sbt.mipt.oop.entities.Door;
import ru.sbt.mipt.oop.entities.SmartHome;

import static ru.sbt.mipt.oop.events.EventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.events.EventType.DOOR_OPENED;

public class DoorsEventHandler implements EventHandler {
    @Override
    public void handle(SmartHome smartHome, Event event) {
        if (isDoorEvent(event)) {
            smartHome.executeAction(Door.class, obj -> {
                Door door = (Door) obj;
                if (door.getId().equals(event.getObjectId())) {
                    changeDoorStatus(event, door);
                }
            });
        }
    }

    private boolean isDoorEvent(Event event) {
        return event.getType() == DOOR_OPENED || event.getType() == DOOR_CLOSED;
    }

    private void changeDoorStatus(Event event, Door door) {
        if (event.getType() == DOOR_OPENED
                && !door.isOpen()) {
            door.setOpen(true);
            System.out.println("Door " + door.getId() + " in room " + door.getRoomName() + " was opened.");
        } else if (event.getType() == DOOR_CLOSED
                && door.isOpen()) {
            door.setOpen(false);
            System.out.println("Door " + door.getId() + " in room " + door.getRoomName() + " was closed.");
        }
    }
}
