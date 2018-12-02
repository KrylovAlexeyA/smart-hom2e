package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;
//лекция 5
public class DoorEventProcessor implements IEventProcessor {

    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isDoorEvent(event)) return;
        // событие от двери
        smartHome.executeAction(object -> {
            if (object instanceof Door) {
                Door door = (Door) object;
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        changeDoorState(door, true, " was opened.");
                    } else {
                        changeDoorState(door, false, " was closed.");
                    }
                }
            }

        }
        );
    }

    private void changeDoorState(Door door, boolean opened, String s) {
        door.setOpen(opened);
        System.out.println("Door " + door.getId() + " in room " + s);
    }

    private boolean isDoorEvent(SensorEvent event) {
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED;
    }
}
