package ru.sbt.mipt.oop.sensors.handlers;

import ru.sbt.mipt.oop.events.Event;
import ru.sbt.mipt.oop.entities.SmartHome;

public interface EventHandler {
    void handle(SmartHome smartHome, Event event);
}
