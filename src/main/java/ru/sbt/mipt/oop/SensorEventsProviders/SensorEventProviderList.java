package ru.sbt.mipt.oop.SensorEventsProviders;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;


import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class SensorEventProviderList implements  ISensorEventProvider {
    private int count = 0;
    public SensorEvent getNextSensorEvent() {
        if (count > 0){
            return null;
        }
        SensorEventType sensorEventType = DOOR_OPEN;
        String objectId = "1";
        count += 1;
        return new SensorEvent(sensorEventType, objectId);
    }

}
