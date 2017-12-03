package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.event_processors.EventHandler;

import java.util.ArrayList;
import java.util.Collection;

public class SensorEventObserver {
    private Collection<EventHandler> eventHandlers = new ArrayList<>();
    private SmartHome smartHome;
    private EventProducer eventProducer;

    public SensorEventObserver(SmartHome smartHome, EventProducer eventProducer) {
        this.smartHome = smartHome;
        this.eventProducer = eventProducer;
    }

    public void runEventCycle() {
        SensorEvent event = eventProducer.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler eventHandler : eventHandlers) {
                eventHandler.handle(smartHome, event);
            }
            event = eventProducer.getNextSensorEvent();
        }
    }

    public void setEventHandlers(Collection<EventHandler> eventHandlers) {
        this.eventHandlers = eventHandlers;
    }
}