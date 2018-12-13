package ru.sbt.mipt.oop.remoteController.commandsOfController;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.remoteController.IRCcommand;

public class LigthsOffCommand implements IRCcommand {

    private SmartHome smartHome;

    public LigthsOffCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {

        smartHome.turnOffLights();
    }
}