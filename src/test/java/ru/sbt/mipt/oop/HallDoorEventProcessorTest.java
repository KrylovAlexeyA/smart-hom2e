package ru.sbt.mipt.oop;

import org.junit.*;
import ru.sbt.mipt.oop.EventProcessors.HallDoorEventProcessor;
import ru.sbt.mipt.oop.simpleElements.Light;
import ru.sbt.mipt.oop.simpleElements.Room;

import static org.junit.Assert.*;

public class HallDoorEventProcessorTest {


    private HallDoorEventProcessor hallDoorEventProcessor;
    SmartHome smarthome = new SmartHome();
    SensorEventType sensoreventtype1 = SensorEventType.DOOR_CLOSED;
    String objectId1 = "4";
    SensorEvent sensorevent1 = new SensorEvent(sensoreventtype1, objectId1);

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before HallDoorEventProcessor.class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After HallDoorEventProcessor.class");
    }

    @Before
    public void initTest() {
        hallDoorEventProcessor = new HallDoorEventProcessor();
    }

    @After
    public void afterTest() {
        hallDoorEventProcessor = null;
    }

    @Test
    public void processEvent() {
        boolean i1 = true, i2 = true, i3 = true;
        System.out.println("First test");
        hallDoorEventProcessor.processEvent(smarthome, sensorevent1);
        for (Room room : smarthome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals("7"))
                    if (light.isOn() == false)
                        i1 = false;
                    else
                        i1 = true;
                if (light.getId().equals("8"))
                    if (light.isOn() == false)
                        i2 = false;
                    else
                        i2 = true;
                if (light.getId().equals("9"))
                    if (light.isOn() == false)
                        i3 = false;
                    else
                        i3 = true;
                assertEquals(false, i1 & i2 & i3);
            }
        }

    }
}