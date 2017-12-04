package ru.sbt.mipt.oop.utils;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.entities.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SmartHomeJsonFileReader {
    static SmartHome getSmartHome() throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get("src/main/resources/my-smart-home.json")));
        return gson.fromJson(json, SmartHome.class);
    }
}
