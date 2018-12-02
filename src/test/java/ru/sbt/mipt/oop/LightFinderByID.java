package ru.sbt.mipt.oop;

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

