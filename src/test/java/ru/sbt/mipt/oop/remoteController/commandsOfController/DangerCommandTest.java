package ru.sbt.mipt.oop.remoteController.commandsOfController;

import org.junit.Test;
import ru.sbt.mipt.oop.alarm.ActivatedState;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.DangerSignalState;
import ru.sbt.mipt.oop.remoteController.ControlPanel;

import static org.junit.Assert.*;

public class DangerCommandTest {
    Alarm alarm = new Alarm(1234,1234);
    ControlPanel controlPanel = new ControlPanel();
    DangerCommand dangerCommand = new DangerCommand(alarm);

    @Test
    public void execute() {
        System.out.println("danger command test");
        dangerCommand.execute();
        alarm.getState();
        assertTrue(alarm.getState() instanceof DangerSignalState);
        System.out.println("It's ok");
    }



}