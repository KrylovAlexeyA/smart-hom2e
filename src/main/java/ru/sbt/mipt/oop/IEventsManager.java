package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventProcessors.IEventProcessor;

public interface IEventsManager {

    void registerEventProcessor(IEventProcessor eventProcessor);
    void runSensorEvent(SmartHome smartHome, SensorEvent event);
    void runEventsCycle(SmartHome smartHome);

}

