package ru.sbt.mipt.oop.sensors.alarm_system;

import ru.sbt.mipt.oop.events.Event;

public class AlarmSystemStateAlarm implements AlarmSystemState {
    private final AlarmSystem alarmSystem;

    public AlarmSystemStateAlarm(AlarmSystem system) {
        alarmSystem = system;
    }

    @Override
    public AlarmSystemStates getState() {
        return AlarmSystemStates.ALARM;
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void turnOff() {
    }

    @Override
    public void onEvent(Event event) {
        return;
    }

    @Override
    public void enterPassword(String password) {
        if (alarmSystem.isPasswordCorrect(password)) {
            alarmSystem.setAlarmSystemState(new AlarmSystemStateOn(alarmSystem));
        }
    }
}


