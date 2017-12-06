package ru.sbt.mipt.oop.events;

import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.sensors.commands.CommandHandler;
import ru.sbt.mipt.oop.sensors.commands.CommandHandlersStatus;
import ru.sbt.mipt.oop.sensors.handlers.EventHandler;

import java.util.ArrayList;
import java.util.Collection;

public class EventObserver implements CommandHandlersStatus {
    private Collection<EventHandler> eventHandlers = new ArrayList<>();
    private SmartHome smartHome;

    public EventObserver(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public void handleEvent(Event event) {
        for (EventHandler eventHandler : eventHandlers) {
            eventHandler.handle(smartHome, event);
        }
    }

    public void setEventHandlers(Collection<EventHandler> eventHandlers) {
        this.eventHandlers = eventHandlers;
    }

    @Override
    public void changeCommandHandlersStatus(boolean isActive) {
        for (EventHandler eventHandler : eventHandlers) {
            if (eventHandler instanceof CommandHandler) {
                ((CommandHandler) eventHandler).setHandlerStatus(isActive);
            }
        }
    }
}