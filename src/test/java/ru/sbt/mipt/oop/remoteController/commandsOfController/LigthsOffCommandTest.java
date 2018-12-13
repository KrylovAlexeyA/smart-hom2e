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

public class LigthsOffCommandTest  {
    Alarm alarm = new Alarm(1234,1234);
    ControlPanel controlPanel = new ControlPanel();
    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    SmartHome smartHome = smartHomeLoader.loadSmartHome();
    LigthsOffCommand ligthsOffCommand = new LigthsOffCommand(smartHome);

    public LigthsOffCommandTest() throws IOException {
    }


    @Test
    public void execute() {
        System.out.println("LigthsOffCommand test");
        LigthsOffCommand ligthsOffCommand = new LigthsOffCommand(smartHome);
        ligthsOffCommand.execute();
        Boolean isAllLightsOff = (LightFinderByID.findLightByID(smartHome,"1").isOn() &&
                LightFinderByID.findLightByID(smartHome,"2").isOn() &&
                LightFinderByID.findLightByID(smartHome,"3").isOn() &&
                LightFinderByID.findLightByID(smartHome,"4").isOn() &&
                LightFinderByID.findLightByID(smartHome,"5").isOn() &&
                LightFinderByID.findLightByID(smartHome,"6").isOn() &&
                LightFinderByID.findLightByID(smartHome,"7").isOn() &&
                LightFinderByID.findLightByID(smartHome,"8").isOn() &&
                LightFinderByID.findLightByID(smartHome,"9").isOn());
        assertEquals(false,isAllLightsOff);
        System.out.println("It's ok");

    }
}