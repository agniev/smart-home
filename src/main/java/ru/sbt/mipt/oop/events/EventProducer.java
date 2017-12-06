package ru.sbt.mipt.oop.events;

import ru.sbt.mipt.oop.sensors.alarm_system.AlarmSystem;

public class EventProducer {

    private AlarmSystem alarmSystem;

    public EventProducer(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    public Event getNextEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of events stream
        EventType eventType = EventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new Event(eventType, objectId);
    }

    public void runEventCycle() {
        Event event = getNextEvent();
        while (event != null) {
            System.out.println("Got events: " + event);
            alarmSystem.onEvent(event);
            event = getNextEvent();
        }
    }
}