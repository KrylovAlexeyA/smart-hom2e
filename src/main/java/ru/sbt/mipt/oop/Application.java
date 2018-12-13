package ru.sbt.mipt.oop;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.EventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessors.HallDoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessors.LightsEventProcessor;
import ru.sbt.mipt.oop.SensorEventsProviders.RandomSensorEventProvider;
import ru.sbt.mipt.oop.SmartHomeLoading.FileSmartHomeLoader;
import ru.sbt.mipt.oop.SmartHomeLoading.SmartHomeLoader;

import java.io.IOException;


public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);

    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    private static HomeEventsObserver homeEventsObserver = new HomeEventsObserver(new RandomSensorEventProvider());
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); //это пока заготовка

    public static void setSmartHomeLoader(SmartHomeLoader smartHomeLoader) {
        Application.smartHomeLoader = smartHomeLoader;
    }

    public static void main(String... args) throws IOException {
        logger.info("Starting configuration...");//и это заготовка
        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        homeEventsObserver.registerEventProcessor(new LightsEventProcessor());
        homeEventsObserver.registerEventProcessor(new DoorEventProcessor());
        homeEventsObserver.registerEventProcessor(new HallDoorEventProcessor());
        homeEventsObserver.runEventsCycle(smartHome);


    }



}
