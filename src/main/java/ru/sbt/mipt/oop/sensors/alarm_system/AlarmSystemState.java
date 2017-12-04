package ru.sbt.mipt.oop.sensors.alarm_system;

import ru.sbt.mipt.oop.events.Event;

public interface AlarmSystemState {
    AlarmSystemStates getState();

    void turnOn();

    void turnOff();

    void onEvent(Event event);

    void enterPassword(String password);
}