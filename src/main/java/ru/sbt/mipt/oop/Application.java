package ru.sbt.mipt.oop;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.sbt.mipt.oop.EventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessors.HallDoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessors.IEventProcessor;
import ru.sbt.mipt.oop.EventProcessors.LightsEventProcessor;
import ru.sbt.mipt.oop.SmartHomeLoading.FileSmartHomeLoader;
import ru.sbt.mipt.oop.SmartHomeLoading.SmartHomeLoader;

import java.io.IOException;
import java.util.ArrayList;



public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);

    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    private static HomeEventsObserver homeEventsObserver = new HomeEventsObserver(new RandomSensorEventProvider());

    public static void setSmartHomeLoader(SmartHomeLoader smartHomeLoader) {
        Application.smartHomeLoader = smartHomeLoader;
    }

    public static void main(String... args) throws IOException {
        logger.info("Starting configuration...");
        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        homeEventsObserver.registerEventProcessor(new LightsEventProcessor());
        homeEventsObserver.registerEventProcessor(new DoorEventProcessor());
        homeEventsObserver.registerEventProcessor(new HallDoorEventProcessor());
        homeEventsObserver.runEventsCycle(smartHome);
    }

    private static ArrayList<IEventProcessor> configureEventProcessors() {
        ArrayList<IEventProcessor> eventProcessors = new ArrayList<>();
        eventProcessors.add(new LightsEventProcessor());
        eventProcessors.add(new DoorEventProcessor());
        eventProcessors.add(new HallDoorEventProcessor());
        return eventProcessors;
    }

}
