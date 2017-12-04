package ru.sbt.mipt.oop.utils;

import ru.sbt.mipt.oop.entities.SmartHome;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SmartHomeSaver {
    static void saveSmartHome(SmartHome smartHome) throws IOException {
        String jsonString = SmartHomeTransformer.transform(smartHome);
        Path path = Paths.get("src/main/resources/output.json");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonString);
        }
    }
}
