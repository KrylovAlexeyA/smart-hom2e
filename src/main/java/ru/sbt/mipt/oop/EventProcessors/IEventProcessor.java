package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public interface IEventProcessor {

     public void processEvent(SmartHome smartHome, SensorEvent event);

}
