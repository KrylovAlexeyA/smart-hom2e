package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.EventProcessors.IEventProcessor;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.simpleElements.Door;
import ru.sbt.mipt.oop.simpleElements.Room;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
//лекция 5
//TODO Спросить как реализовать обход итератором , если нужно еще знать комнату,чтобы проверить ее на hall??
public class HallDoorEventProcessor implements IEventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() != DOOR_CLOSED) return;
        // событие от двери
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                    if (room.getName().equals("hall")) {
                        smartHome.turnOffLights();
                    }
                }
            }
        }
    }
}
