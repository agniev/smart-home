package ru.sbt.mipt.oop.sensors.handlers;

import ru.sbt.mipt.oop.Application;
import ru.sbt.mipt.oop.events.Event;
import ru.sbt.mipt.oop.sensors.commands.Command;
import ru.sbt.mipt.oop.sensors.commands.CommandType;
import ru.sbt.mipt.oop.entities.Door;
import ru.sbt.mipt.oop.entities.Light;
import ru.sbt.mipt.oop.entities.SmartHome;

import static ru.sbt.mipt.oop.events.EventType.DOOR_CLOSED;

public class AutoEventHandler implements EventHandler {
    // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
    @Override
    public void handle(SmartHome smartHome, Event event) {
        if (isDoorClosedEvent(event)) {
            smartHome.executeAction(object -> {
                if (object instanceof Door) {
                    Door door = (Door) object;
                    if (door.getId().equals(event.getObjectId())
                            && door.getRoomName().equals("hall")) {
                        turnOffHomeLights(smartHome);
                    }
                }
            });
        }
    }

    private void turnOffHomeLights(SmartHome smartHome) {
        smartHome.executeAction(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                light.setOn(false);
                Command command = new Command(CommandType.LIGHT_OFF, light.getId());
                Application.sendCommand(command);
            }
        });
        System.out.println("All lights were turned off.");
    }

    private boolean isDoorClosedEvent(Event event) {
        return event.getType() == DOOR_CLOSED;
    }
}
