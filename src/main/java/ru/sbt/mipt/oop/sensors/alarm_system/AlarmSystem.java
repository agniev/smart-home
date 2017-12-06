package ru.sbt.mipt.oop.sensors.alarm_system;


import ru.sbt.mipt.oop.events.Event;
import ru.sbt.mipt.oop.events.EventObserver;

public class AlarmSystem implements AlarmSystemState {
    private final String password;
    private AlarmSystemState alarmSystemState;
    private EventObserver eventObserver;

    public AlarmSystem(String password, EventObserver eventObserver) {
        this.password = password;
        alarmSystemState = new AlarmSystemStateOff(this);
        this.eventObserver = eventObserver;
    }

    @Override
    public AlarmSystemStates getState() {
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
    public void onEvent(Event event) {
        alarmSystemState.onEvent(event);
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

    public EventObserver getEventObserver() {
        return eventObserver;
    }
}