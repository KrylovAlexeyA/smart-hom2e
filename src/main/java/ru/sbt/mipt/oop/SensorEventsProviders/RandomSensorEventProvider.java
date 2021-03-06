package ru.sbt.mipt.oop.SensorEventsProviders;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SensorEventsProviders.ISensorEventProvider;

public class RandomSensorEventProvider implements ISensorEventProvider {
    public SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        if (objectId.equals("0")){
            return null;
        }
        return new SensorEvent(sensorEventType, objectId);
    }
}
