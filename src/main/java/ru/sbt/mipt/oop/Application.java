package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event_processors.DoorsEventProcessor;
import ru.sbt.mipt.oop.event_processors.EventHandler;
import ru.sbt.mipt.oop.event_processors.LightsEventProcessor;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        SmartHome smartHome = GetSmartHome.getSmartHome();
        // начинаем цикл обработки событий
        Collection<EventHandler> eventHandlers = new LinkedList<>();
        eventHandlers.add(new LightsEventProcessor());
        eventHandlers.add(new DoorsEventProcessor());

        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler eventHandler: eventHandlers){
                eventHandler.handle(smartHome,event);
            }
            event = getNextSensorEvent();
        }
    }

    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
