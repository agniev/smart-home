package ru.sbt.mipt.oop.sensors.handlers;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.entities.Light;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.events.Event;
import ru.sbt.mipt.oop.events.EventType;

import static org.junit.Assert.assertFalse;

public class AutoEventHandlerTest {
    SmartHome home;
    AutoEventHandler autoEventHandler;

    @Before
    public void init() {
        this.home = HomeBuilderForTests.initSmartHome();
        autoEventHandler = AutoEventHandler.getAutoEventHandler();
    }

    @Test
    public void hallDoorCloseTest() throws Exception {
        Event event = new Event(EventType.DOOR_CLOSED, "4");
        autoEventHandler.handle(home, event);

        home.executeAction(Light.class, obj -> {
            Light light = (Light) obj;
            assertFalse(light.isOn());
        });
    }

    @Test
    public void otherEventsTest() throws Exception {
        Event event = new Event(EventType.DOOR_CLOSED, "3");
        autoEventHandler.handle(home, event);

        final boolean[] allLightsOn = {true};
        checkIfAllLightsOn(allLightsOn);

        event = new Event(EventType.DOOR_OPENED, "2");
        autoEventHandler.handle(home, event);

        allLightsOn[0] = true;
        checkIfAllLightsOn(allLightsOn);

        event = new Event(EventType.LIGHT_ON, "1");
        autoEventHandler.handle(home, event);

        allLightsOn[0] = true;
        checkIfAllLightsOn(allLightsOn);

        event = new Event(EventType.LIGHT_OFF, "2");
        autoEventHandler.handle(home, event);

        allLightsOn[0] = true;
        checkIfAllLightsOn(allLightsOn);
    }

    private void checkIfAllLightsOn(boolean[] allLightsOn) {
        home.executeAction(Light.class, obj -> {
            Light light = (Light) obj;
            if (!light.isOn()) {
                allLightsOn[0] = false;
            }
        });
        assertFalse(allLightsOn[0]);
    }
}