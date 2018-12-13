package ru.sbt.mipt.oop.remoteController.commandsOfController;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.remoteController.IRCcommand;

//TODO выключение всего света!!!!!!!

public class LigthsOnCommand implements IRCcommand {

    private SmartHome smartHome;

    public LigthsOnCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {

        smartHome.turnOnLights();
    }
}
