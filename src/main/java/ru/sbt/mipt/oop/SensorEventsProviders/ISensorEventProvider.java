package ru.sbt.mipt.oop.SensorEventsProviders;


import ru.sbt.mipt.oop.SensorEvent;

public interface ISensorEventProvider {

    public SensorEvent getNextSensorEvent();

}
