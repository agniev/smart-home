package ru.sbt.mipt.oop.event_processors;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by KIDCLASS on 13.10.2017.
 */
class LightsEventProcessorTest {
    @Test
    public void superTest() throws Exception {
        LightsEventProcessor lightsEventProcessor = new LightsEventProcessor();
        SmartHome home = new SmartHome();
        String lightId = "1";
        Light light = new Light(lightId, false);
        home.addRoom(new Room(Arrays.asList(light),
                Collections.emptyList(),
                "room"));
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, "2");
        lightsEventProcessor.handle(home, event);
        assertTrue(light.isOn());
    }

}