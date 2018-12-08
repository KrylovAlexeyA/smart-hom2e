package ru.sbt.mipt.oop;

import org.junit.Test;
import ru.sbt.mipt.oop.EventProcessors.LightsEventProcessor;
import ru.sbt.mipt.oop.SmartHomeLoading.FileSmartHomeLoader;
import ru.sbt.mipt.oop.SmartHomeLoading.SmartHomeLoader;
import ru.sbt.mipt.oop.simpleElements.Light;

import java.io.IOException;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.LightFinderByID.findLightByID;

public class LightFinderByIDTest  {
    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    SmartHome smartHome = smartHomeLoader.loadSmartHome();
    private LightsEventProcessor lightsEventProcessor;
    SensorEventType sensoreventtype1 = SensorEventType.LIGHT_ON;
    SensorEventType sensoreventtype2 = SensorEventType.LIGHT_OFF;
    String objectId = "1";


    public LightFinderByIDTest() throws IOException {
    }

    @Test
    public void findLightByIDTest() {
        System.out.println("First test");
        Light light2 = findLightByID(this.smartHome, this.objectId);
        System.out.println(light2.getId());
        assertEquals("1", light2.getId());

    }
}



