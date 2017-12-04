package ru.sbt.mipt.oop.sensors.handlers;

import ru.sbt.mipt.oop.entities.Light;
import ru.sbt.mipt.oop.events.Event;
import ru.sbt.mipt.oop.entities.SmartHome;

import static ru.sbt.mipt.oop.events.EventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.events.EventType.LIGHT_ON;

public class LightsEventHandler implements EventHandler{
    @Override
    public void handle(SmartHome smartHome, Event event) {
        if (isLightEvent(event)) {
            smartHome.executeAction(obj -> {
                if (obj instanceof Light){
                    Light light = (Light) obj;
                    if (light.getId().equals(event.getObjectId())) {
                        changeLightStatus(event, light);
                    }
                }
            });
        }
    }

    private boolean isLightEvent(Event event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }

    private void changeLightStatus(Event event, Light light) {
        if (event.getType() == LIGHT_ON) {
            light.setOn(true);
            System.out.println("Light " + light.getId() + " in room " + light.getRoomName() + " was turned on.");
        } else {
            light.setOn(false);
            System.out.println("Light " + light.getId() + " in room " + light.getRoomName() + " was turned off.");
        }
    }
}
