package ru.sbt.mipt.oop.sensors.commands;

public class Command {
    private final CommandType type;
    private final String objectId;

    public Command(CommandType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return "Command{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
