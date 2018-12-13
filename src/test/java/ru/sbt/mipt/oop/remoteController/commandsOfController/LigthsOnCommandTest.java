package ru.sbt.mipt.oop.remoteController.commandsOfController;

import org.junit.Test;
import ru.sbt.mipt.oop.LightFinderByID;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SmartHomeLoading.FileSmartHomeLoader;
import ru.sbt.mipt.oop.SmartHomeLoading.SmartHomeLoader;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.remoteController.ControlPanel;

import java.io.IOException;

import static org.junit.Assert.*;

public class LigthsOnCommandTest {
    Alarm alarm = new Alarm(1234,1234);
    ControlPanel controlPanel = new ControlPanel();
    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    SmartHome smartHome = smartHomeLoader.loadSmartHome();
    LigthsOnCommand ligthsOnCommand = new LigthsOnCommand(smartHome);

    public LigthsOnCommandTest() throws IOException {
    }

    @Test
    public void execute() {
        System.out.println("LigthsOnCommand test");
        LigthsOnCommand ligthsOnCommand = new LigthsOnCommand(smartHome);
        ligthsOnCommand.execute();
        Boolean isAllLightsOff = (LightFinderByID.findLightByID(smartHome,"1").isOn() &&
                LightFinderByID.findLightByID(smartHome,"2").isOn() &&
                LightFinderByID.findLightByID(smartHome,"3").isOn() &&
                LightFinderByID.findLightByID(smartHome,"4").isOn() &&
                LightFinderByID.findLightByID(smartHome,"5").isOn() &&
                LightFinderByID.findLightByID(smartHome,"6").isOn() &&
                LightFinderByID.findLightByID(smartHome,"7").isOn() &&
                LightFinderByID.findLightByID(smartHome,"8").isOn() &&
                LightFinderByID.findLightByID(smartHome,"9").isOn());
        assertEquals(true,isAllLightsOff);
        System.out.println("It's ok");
    }
}