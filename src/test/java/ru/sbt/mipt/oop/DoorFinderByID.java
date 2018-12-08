package ru.sbt.mipt.oop;


import ru.sbt.mipt.oop.simpleElements.Door;
import ru.sbt.mipt.oop.simpleElements.Room;

public class DoorFinderByID {
    public static Door findDoorByID(SmartHome smartHome, String Id ){
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(Id)) {
                    return door;
                }


            }
        }
        return null;

    }

}
