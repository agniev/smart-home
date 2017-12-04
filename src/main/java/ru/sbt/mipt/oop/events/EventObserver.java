package ru.sbt.mipt.oop.events;

import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.sensors.handlers.EventHandler;

import java.util.ArrayList;
import java.util.Collection;

public class EventObserver {
    private Collection<EventHandler> eventHandlers = new ArrayList<>();
    private SmartHome smartHome;
    private EventProducer eventProducer;

    public EventObserver(SmartHome smartHome, EventProducer eventProducer) {
        this.smartHome = smartHome;
        this.eventProducer = eventProducer;
    }

    public void runEventCycle() {
        Event event = eventProducer.getNextEvent();
        while (event != null) {
            System.out.println("Got events: " + event);
            for (EventHandler eventHandler : eventHandlers) {
                eventHandler.handle(smartHome, event);
            }
            event = eventProducer.getNextEvent();
        }
    }

    public void setEventHandlers(Collection<EventHandler> eventHandlers) {
        this.eventHandlers = eventHandlers;
    }
}