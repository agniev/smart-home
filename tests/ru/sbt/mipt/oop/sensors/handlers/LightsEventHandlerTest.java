package ru.sbt.mipt.oop.sensors.handlers;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.events.Event;
import ru.sbt.mipt.oop.events.EventType;
import ru.sbt.mipt.oop.entities.Light;
import ru.sbt.mipt.oop.entities.Room;
import ru.sbt.mipt.oop.entities.SmartHome;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class LightsEventHandlerTest {
    @Test
    public void superTest() throws Exception {
        LightsEventHandler lightsEventHandler = new LightsEventHandler();
        SmartHome home = new SmartHome();
        String lightId = "1";
        Light light = new Light(lightId, false);
        home.addRoom(new Room(Arrays.asList(light),
                Collections.emptyList(),
                "room"));
        Event event = new Event(EventType.LIGHT_ON, "2");
        lightsEventHandler.handle(home, event);
        assertTrue(light.isOn());
    }
}