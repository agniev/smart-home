package ru.sbt.mipt.oop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sbt.mipt.oop.events.EventObserver;
import ru.sbt.mipt.oop.sensors.commands.Command;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        EventObserver eventObserver = (EventObserver) ctx.getBean("eventObserver");
        eventObserver.runEventCycle();
    }

    public static void sendCommand(Command command) {
        System.out.println("Pretent we're sending commands " + command);
    }
}
