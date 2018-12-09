
package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventProcessors.IEventProcessor;

import java.util.ArrayList;


//лекция 6
public class HomeEventsObserver implements IEventsManager {
    private final ArrayList<IEventProcessor> eventProcessors = new ArrayList<>();
    private ISensorEventProvider sensorEventProvider;

    public HomeEventsObserver(ISensorEventProvider sensorEventProvider) {
        this.sensorEventProvider = sensorEventProvider;
    }

    public HomeEventsObserver(){
    }

    @Override
    public void registerEventProcessor(IEventProcessor eventProcessor) {
        eventProcessors.add(eventProcessor);
    }

    @Override
    public void runSensorEvent(SmartHome smartHome, SensorEvent event){
        System.out.println("Event: " + event.toString());
        for (IEventProcessor eventProcessor : eventProcessors) {
            eventProcessor.processEvent(smartHome, event);
        }
    }

    @Override
    public void runEventsCycle(SmartHome smartHome) {
        SensorEvent event = sensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Event: " + event.toString());
            for (IEventProcessor eventProcessor : eventProcessors) {
                eventProcessor.processEvent(smartHome, event);
            }
            event = sensorEventProvider.getNextSensorEvent();
        }
    }
}
