package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.simpleElements.Light;
import ru.sbt.mipt.oop.simpleElements.Room;

public class LightFinderByID {
    public static Light findLightByID(SmartHome smartHome, String Id ){
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(Id))
                    return light;
            }
        }
        return null;
    }


}

