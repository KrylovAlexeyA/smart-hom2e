package ru.sbt.mipt.oop.SmartHomeLoading;

import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;

public interface SmartHomeLoader {
    SmartHome loadSmartHome() throws IOException;
}
