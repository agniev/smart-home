package ru.sbt.mipt.oop.entities;

import java.util.Collection;

import static ru.sbt.mipt.oop.entities.EntityType.DOOR;
import static ru.sbt.mipt.oop.entities.EntityType.LIGHT;
import static ru.sbt.mipt.oop.entities.EntityType.ROOM;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
        for (Door door : getDoors()) {
            door.setRoomName(getName());
        }
        for (Light light : getLights()) {
            light.setRoomName(getName());
        }
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void executeAction(Class objectClass, Action action) {
        switch (objectClass.getName()) {
            case DOOR:
                for (Door door : getDoors()) {
                    door.executeAction(objectClass, action);
                }
                break;
            case LIGHT:
                for (Light light : getLights()) {
                    light.executeAction(objectClass, action);
                }
                break;
            case ROOM:
                action.execute(this);
                break;
        }
    }
}
