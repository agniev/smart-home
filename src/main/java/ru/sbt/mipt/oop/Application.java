package ru.sbt.mipt.oop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sbt.mipt.oop.events.EventObserver;
import ru.sbt.mipt.oop.events.EventProducer;
import ru.sbt.mipt.oop.sensors.alarm_system.AlarmSystem;
import ru.sbt.mipt.oop.sensors.commands.Command;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        EventObserver eventObserver = (EventObserver) ctx.getBean("eventObserver");
        AlarmSystem alarmSystem = new AlarmSystem("1234", eventObserver);
        alarmSystem.turnOn();
        EventProducer eventProducer = new EventProducer(alarmSystem);
        eventProducer.runEventCycle();
    }

    public static void sendCommand(Command command) {
        System.out.println("Pretend we're sending commands " + command);
    }
}
