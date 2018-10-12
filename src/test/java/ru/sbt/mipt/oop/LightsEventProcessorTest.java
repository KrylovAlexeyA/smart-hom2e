package ru.sbt.mipt.oop;

import org.junit.*;

import static org.junit.Assert.*;



public class LightsEventProcessorTest {

    private LightsEventProcessor lightsEventProcessor;
    SmartHome smarthome = new SmartHome();
    SensorEventType sensoreventtype1 = SensorEventType.LIGHT_ON;
    SensorEventType sensoreventtype2 = SensorEventType.LIGHT_OFF;
    String objectId = "1";
    String objectId2 = "2";
    SensorEvent sensorevent1 = new SensorEvent(sensoreventtype1, objectId);
    SensorEvent sensorevent2 = new SensorEvent(sensoreventtype2, objectId2);

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before LightsEventProcessorTest.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After LightsEventProcessorTest.class");
    }

    @Before
    public void initTest() {
        lightsEventProcessor = new LightsEventProcessor();
    }

    @After
    public void afterTest() {
        lightsEventProcessor = null;
    }

    @Test
    public void processEvent() {
        System.out.println("First test");
        lightsEventProcessor.processEvent(smarthome,sensorevent1);
        for (Room room : smarthome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals("1"))
                    assertEquals(true, light.isOn());
            }
        }
        lightsEventProcessor.processEvent(smarthome,sensorevent2);
        System.out.println("Second test");
        for (Room room : smarthome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals("2"))
                    assertEquals(false, light.isOn());
            }
        }

    }


}