package ru.sbt.mipt.oop;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class DoorEventProcessorTest {

    private DoorEventProcessor dooreventprocessor;
    SmartHome smarthome = new SmartHome();
    SensorEventType sensoreventtype1 = SensorEventType.DOOR_OPEN;
    SensorEventType sensoreventtype2 = SensorEventType.DOOR_CLOSED;
    String objectId = "1";
    String objectId2 = "2";
    SensorEvent sensorevent1 = new SensorEvent(sensoreventtype1, objectId);
    SensorEvent sensorevent2 = new SensorEvent(sensoreventtype2, objectId2);

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
        dooreventprocessor = new DoorEventProcessor();
    }

    @After
    public void afterTest() {
        dooreventprocessor = null;
    }

    @Test
    public void processEvent() {
        System.out.println("First test");
        dooreventprocessor.processEvent(smarthome,sensorevent1);
        for (Room room : smarthome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals("1"))
                    assertEquals(true, door.getIsOpen());
            }
        }
        dooreventprocessor.processEvent(smarthome,sensorevent2);
        System.out.println("Second test");
        for (Room room : smarthome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals("2"))
                    assertEquals(false, door.getIsOpen());
            }
        }

    }


}