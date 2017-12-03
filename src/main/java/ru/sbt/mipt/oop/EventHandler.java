package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.entities.SmartHome;

public interface EventHandler {
    void handle(SmartHome smartHome, SensorEvent event);
}
