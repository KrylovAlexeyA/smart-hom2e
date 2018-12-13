package ru.sbt.mipt.oop.remoteController.commandsOfController;

import org.junit.Test;
import ru.sbt.mipt.oop.alarm.ActivatedState;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.remoteController.ControlPanel;

import static org.junit.Assert.*;

public class ActivateCommandTest {
    Alarm alarm = new Alarm(1234,1234);
    ControlPanel controlPanel = new ControlPanel();
    ActivateCommand activateCommand = new ActivateCommand(alarm);
    @Test
    public void execute() {
        System.out.println("activation test");
        activateCommand.execute();
        alarm.getState();
        assertTrue(alarm.getState() instanceof ActivatedState);
        System.out.println("It's ok");

    }
}