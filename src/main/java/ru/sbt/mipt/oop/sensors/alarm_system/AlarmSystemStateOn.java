package ru.sbt.mipt.oop.sensors.alarm_system;

import ru.sbt.mipt.oop.events.Event;

public class AlarmSystemStateOn implements AlarmSystemState {

    private final AlarmSystem alarmSystem;

    public AlarmSystemStateOn(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public AlarmSystemStates getState() {
        return AlarmSystemStates.ON;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void onEvent(Event event) {
        alarmSystem.setAlarmSystemState(new AlarmSystemStateWaitForPassword(alarmSystem));
    }

    @Override
    public void enterPassword(String password) {

    }
}