package ru.sbt.mipt.oop.alarm_system;

import ru.sbt.mipt.oop.SensorEvent;

public interface AlarmSystemState {
    AlarmSystemStateEnum getState();

    void turnOn();

    void turnOff();

    void onSensorEvent(SensorEvent sensorEvent);

    void enterPassword(String password);
}