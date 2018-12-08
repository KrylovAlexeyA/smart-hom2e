package ru.sbt.mipt.oop;

import org.junit.*;
import org.junit.Test;
import ru.sbt.mipt.oop.EventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.SmartHomeLoading.FileSmartHomeLoader;
import ru.sbt.mipt.oop.SmartHomeLoading.SmartHomeLoader;
import ru.sbt.mipt.oop.simpleElements.Door;

import java.io.IOException;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.DoorFinderByID.findDoorByID;


public class DoorEventProcessorTest {
    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    SmartHome smartHome = smartHomeLoader.loadSmartHome();
    private DoorEventProcessor doorEventProcessor;
    SensorEventType sensoreventtype1 = SensorEventType.DOOR_OPEN;
    SensorEventType sensoreventtype2 = SensorEventType.DOOR_CLOSED;
    String objectId = "1";
    String objectId2 = "2";
    SensorEvent sensorEvent1 = new SensorEvent(sensoreventtype1, objectId);
    SensorEvent sensorEvent2 = new SensorEvent(sensoreventtype2, objectId2);

    public DoorEventProcessorTest() throws IOException {
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before DoorEventProcessorTest.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After DoorEventProcessorTest.class");
    }

    @Before
    public void initTest() {
        doorEventProcessor = new DoorEventProcessor();
    }

    @After
    public void afterTest() {
        doorEventProcessor = null;
    }

    @Test
    public void processEvent() {
        System.out.println("First test");
        doorEventProcessor.processEvent(smartHome, sensorEvent1);
        Door door1 = findDoorByID(smartHome,"1");
        System.out.println("First is Ok");
        assertEquals(true, door1.getIsOpen());

        System.out.println("Second test");
        doorEventProcessor.processEvent(smartHome, sensorEvent2);
        Door door2 = findDoorByID(smartHome,"2");
        System.out.println("Second is Ok");
        assertEquals(false, door2.getIsOpen());

    }



}