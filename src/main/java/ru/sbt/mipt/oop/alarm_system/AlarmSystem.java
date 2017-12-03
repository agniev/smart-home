package ru.sbt.mipt.oop.alarm_system;

import ru.sbt.mipt.oop.SensorEvent;

public class AlarmSystem implements AlarmSystemState {
    private final String password;
    private AlarmSystemState alarmSystemState;

    public AlarmSystem(String password) {
        this.password = password;
        alarmSystemState = new AlarmSystemStateOff(this);
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return alarmSystemState.getState();
    }

    @Override
    public void turnOn() {
        alarmSystemState.turnOn();
    }

    @Override
    public void turnOff() {
        alarmSystemState.turnOff();
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
        alarmSystemState.onSensorEvent(sensorEvent);
    }

    @Override
    public void enterPassword(String password) {
        alarmSystemState.enterPassword(password);
    }

    public void setAlarmSystemState(AlarmSystemState systemStateEnum) {
        this.alarmSystemState = systemStateEnum;
    }

    public boolean isPasswordCorrect(String password) {
        return this.password.equals(password);
    }
}