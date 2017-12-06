package ru.sbt.mipt.oop.sensors.alarm_system;

import ru.sbt.mipt.oop.events.Event;

public class AlarmSystemStateOff implements AlarmSystemState {
    private final AlarmSystem alarmSystem;

    public AlarmSystemStateOff(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
        System.out.println("new Alarm system state: Off");
    }

    @Override
    public AlarmSystemStates getState() {
        return AlarmSystemStates.OFF;
    }

    @Override
    public void turnOn() {
        //turn On without password
        alarmSystem.setAlarmSystemState(new AlarmSystemStateOn(alarmSystem));
        alarmSystem.getEventObserver().changeCommandHandlersStatus(false);
        //now handlers can't send commands
        //(when Door 4 in hall is closed lights won't be turned off)
    }

    @Override
    public void turnOff() {
        //do nothing
    }

    @Override
    public void onEvent(Event event) {
        //all handlers are active
        alarmSystem.getEventObserver().handleEvent(event);
    }

    @Override
    public void enterPassword(String password) {
        //do nothing
    }
}