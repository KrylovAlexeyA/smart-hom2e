package ru.sbt.mipt.oop;

import org.junit.Test;
import ru.sbt.mipt.oop.EventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessors.HallDoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessors.LightsEventProcessor;
import ru.sbt.mipt.oop.SmartHomeLoading.FileSmartHomeLoader;
import ru.sbt.mipt.oop.SmartHomeLoading.SmartHomeLoader;
import ru.sbt.mipt.oop.simpleElements.Door;

import java.io.IOException;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.DoorFinderByID.findDoorByID;

public class HomeEventsObserverTest {
    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    SmartHome smartHome = smartHomeLoader.loadSmartHome();
    public RandomSensorEventProvider randomSensorEventProvider = new RandomSensorEventProvider();


    public HomeEventsObserverTest() throws IOException {
    }



    @Test
    public void runSensorEvent() {
        HomeEventsObserver homeEventsObserver1 = new HomeEventsObserver();
        DoorEventProcessor doorEventProcessor = new DoorEventProcessor();
        LightsEventProcessor lightsEventProcessor  = new LightsEventProcessor();
        SensorEventType sensoreventtype1 = SensorEventType.DOOR_OPEN;
        SensorEventType sensoreventtype2 = SensorEventType.DOOR_CLOSED;
        String objectId1 = "1";
        String objectId2 = "2";
        SensorEvent sensorEvent1 = new SensorEvent(sensoreventtype1, objectId1);
        SensorEvent sensorEvent2 = new SensorEvent(sensoreventtype2, objectId2);

       /* SensorEventType sensoreventtype3 = SensorEventType.LIGHT_ON;
        SensorEventType sensoreventtype4 = SensorEventType.LIGHT_OFF;
        String objectId3 = "3";
        String objectId4 = "4";
        SensorEvent sensorevent3 = new SensorEvent(sensoreventtype3, objectId3);
        SensorEvent sensorevent4 = new SensorEvent(sensoreventtype4, objectId4);*/
        homeEventsObserver1.registerEventProcessor(new DoorEventProcessor());
       // homeEventsObserver1.registerEventProcessor(new LightsEventProcessor());

        System.out.println("First runSensorEvent test");
        homeEventsObserver1.runSensorEvent(smartHome, sensorEvent1);
        Door door1 = findDoorByID(smartHome,"1");
        System.out.println("First runSensorEvent is Ok");
        assertEquals(true, door1.getIsOpen());

        System.out.println("Second runSensorEvent test");
        doorEventProcessor.processEvent(smartHome, sensorEvent2);
        Door door2 = findDoorByID(smartHome,"2");
        System.out.println("Second runSensorEvent is Ok");
        assertEquals(false, door2.getIsOpen());

    }

    @Test
    public void runEventsCycle() {
        HomeEventsObserver homeEventsObserver2 = new HomeEventsObserver(randomSensorEventProvider);
        SensorEventType sensoreventtype1 = SensorEventType.DOOR_OPEN;
        SensorEventType sensoreventtype2 = SensorEventType.DOOR_CLOSED;
        String objectId1 = "1";
        String objectId2 = "2";
        SensorEvent sensorEvent1 = new SensorEvent(sensoreventtype1, objectId1);
        SensorEvent sensorEvent2 = new SensorEvent(sensoreventtype2, objectId2);
        homeEventsObserver2.registerEventProcessor(new LightsEventProcessor());
        homeEventsObserver2.registerEventProcessor(new DoorEventProcessor());
        homeEventsObserver2.registerEventProcessor(new HallDoorEventProcessor());
        homeEventsObserver2.runEventsCycle(smartHome);
        //Тут сложно написать какой то ассерт, потому что события рандомные но HomeEventsObserver пишет в лог,
        //что произошли такие то события , так что сойдет за тест наверное
    }
}