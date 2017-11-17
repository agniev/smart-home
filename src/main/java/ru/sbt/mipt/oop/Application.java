package ru.sbt.mipt.oop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        SensorEventObserver sensorEventObserver = (SensorEventObserver) ctx.getBean("sensorEventObserver");
//        SmartHome smartHome = GetSmartHome.getSmartHome();
//        SensorEventObserver sensorEventObserver = new SensorEventObserver(new EventProducer(), smartHome);
//        configureHandlers(sensorEventObserver);
        sensorEventObserver.runEventCycle();
    }

    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
