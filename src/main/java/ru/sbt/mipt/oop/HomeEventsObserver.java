package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventProcessors.IEventProcessor;

import java.util.ArrayList;
import java.util.Collection;
//лекция 6
public class HomeEventsObserver {

    private final Collection<IEventProcessor> eventProcessors = new ArrayList<>();
    private ISensorEventProvider sensorEventProvider;

    public HomeEventsObserver(ISensorEventProvider sensorEventProvider) {
        this.sensorEventProvider = sensorEventProvider;
    }

    public void registerEventProcessor(IEventProcessor eventProcessor) {
        eventProcessors.add(eventProcessor);
    }

    public void runEventsCycle(SmartHome smartHome) {
        SensorEvent event = sensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (IEventProcessor eventProcessor : eventProcessors) {
                eventProcessor.processEvent(smartHome, event);
            }
            event = sensorEventProvider.getNextSensorEvent();
        }
    }
}
