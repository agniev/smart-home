package ru.sbt.mipt.oop.sensors.handlers;

import ru.sbt.mipt.oop.entities.Door;
import ru.sbt.mipt.oop.entities.Light;
import ru.sbt.mipt.oop.entities.Room;
import ru.sbt.mipt.oop.entities.SmartHome;

import java.util.Arrays;

/**
 * Created by Roman on 07.12.2017.
 */
public class HomeBuilderForTests {
    public static SmartHome initSmartHome() {
        //4 rooms
        //9 lights
        //4 doors
        Room kitchen = new Room(
                Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(new Door("1", false)),
                "kitchen");
        Room bathroom = new Room(
                Arrays.asList(new Light("3", true)),
                Arrays.asList(new Door("2", false)),
                "bathroom");
        Room bedroom = new Room(
                Arrays.asList(new Light("4", false), new Light("5", false), new Light("6", false)),
                Arrays.asList(new Door("3", true)),
                "bedroom");
        Room hall = new Room(
                Arrays.asList(new Light("7", false), new Light("8", false), new Light("9", false)),
                Arrays.asList(new Door("4", true)),
                "hall");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen, bathroom, bedroom, hall));
        return smartHome;
    }
}
