package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event_processors.DoorsEventProcessor;
import ru.sbt.mipt.oop.event_processors.EventHandler;
import ru.sbt.mipt.oop.event_processors.LightsEventProcessor;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

public class Application {

    public static void main(String... args) throws IOException {
        SmartHome smartHome = GetSmartHome.getSmartHome();
        SensorEventObserver sensorEventObserver = new SensorEventObserver(new EventProducer(), smartHome);
        configureHandlers(sensorEventObserver);
        sensorEventObserver.runEventCycle();
    }

    private static void configureHandlers(SensorEventObserver observer) {
        observer.addHandler(new LightsEventProcessor());
        observer.addHandler(new DoorsEventProcessor());
    }

    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
