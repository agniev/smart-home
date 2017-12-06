package ru.sbt.mipt.oop.sensors.handlers;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.events.Event;
import ru.sbt.mipt.oop.events.EventType;
import ru.sbt.mipt.oop.entities.Light;
import ru.sbt.mipt.oop.entities.SmartHome;

import static java.lang.String.valueOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LightsEventHandlerTest {
    SmartHome home;
    LightsEventHandler lightsEventHandler;

    @Before
    public void init() {
        this.home = HomeBuilderForTests.initSmartHome();
        lightsEventHandler = new LightsEventHandler();
    }

    @Test
    public void lightOnEventsTest() throws Exception {
        for (int i = 1; i <= 20; i++) {
            Event event = new Event(EventType.LIGHT_ON, valueOf(i));
            lightsEventHandler.handle(home, event);
        }

        home.executeAction(Light.class, obj -> {
            Light light = (Light) obj;
            assertTrue(light.isOn());
        });
    }

    @Test
    public void lightOffEventsTest() throws Exception {
        for (int i = 1; i <= 20; i++) {
            Event event = new Event(EventType.LIGHT_OFF, valueOf(i));
            lightsEventHandler.handle(home, event);
        }

        home.executeAction(Light.class, obj -> {
            Light light = (Light) obj;
            assertFalse(light.isOn());
        });
    }
}