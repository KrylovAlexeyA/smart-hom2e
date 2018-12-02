package ru.sbt.mipt.oop;

import org.junit.*;

import java.io.IOException;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.LightFinderByID.findLightByID;


public class LightsEventProcessorTest {
    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    SmartHome smartHome = smartHomeLoader.loadSmartHome();
    private LightsEventProcessor lightsEventProcessor;
    SensorEventType sensoreventtype1 = SensorEventType.LIGHT_ON;
    SensorEventType sensoreventtype2 = SensorEventType.LIGHT_OFF;
    String objectId = "1";
    String objectId2 = "2";
    SensorEvent sensorevent1 = new SensorEvent(sensoreventtype1, objectId);
    SensorEvent sensorevent2 = new SensorEvent(sensoreventtype2, objectId2);

    public LightsEventProcessorTest() throws IOException {
    }

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
        lightsEventProcessor.processEvent(smartHome,sensorevent1);
        Light light1 = findLightByID(smartHome,"1");
        assertEquals(true, light1.isOn());


        System.out.println("Second test");
        lightsEventProcessor.processEvent(smartHome,sensorevent2);
        Light light2 = findLightByID(smartHome,"2");
        assertEquals(false, light2.isOn());
        }

}



