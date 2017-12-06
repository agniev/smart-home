package ru.sbt.mipt.oop.sensors.handlers;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.entities.Door;
import ru.sbt.mipt.oop.events.Event;
import ru.sbt.mipt.oop.events.EventType;
import ru.sbt.mipt.oop.entities.SmartHome;

import static java.lang.String.valueOf;
import static org.junit.Assert.assertTrue;

public class DoorsEventHandlerTest {
    SmartHome home;
    DoorsEventHandler doorsEventHandler;

    @Before
    public void init() {
        this.home = HomeBuilderForTests.initSmartHome();
        doorsEventHandler = new DoorsEventHandler();
    }

    @Test
    public void doorOpenEventsTest() throws Exception {
        for (int i = 1; i <= 20; i++) {
            Event event = new Event(EventType.DOOR_OPENED, valueOf(i));
            doorsEventHandler.handle(home, event);
        }

        home.executeAction(Door.class, obj -> {
            Door door = (Door) obj;
            assertTrue(door.isOpen());
        });
    }

    @Test
    public void doorClosedEventsTest() throws Exception {
        for (int i = 1; i <= 20; i++) {
            Event event = new Event(EventType.DOOR_CLOSED, valueOf(i));
            doorsEventHandler.handle(home, event);
        }

        home.executeAction(Door.class, obj -> {
            Door door = (Door) obj;
            assertTrue(!door.isOpen());
        });
    }
}