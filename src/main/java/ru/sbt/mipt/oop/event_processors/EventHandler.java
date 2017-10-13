package ru.sbt.mipt.oop.event_processors;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public interface EventHandler {
    void handle(SmartHome smartHome, SensorEvent event);
}
