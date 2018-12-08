package ru.sbt.mipt.oop.remoteController.commandsOfController;

import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.remoteController.IRCcommand;

//Alarm activating
public class ActivateCommand implements IRCcommand {

    private Alarm alarm;

    public ActivateCommand(Alarm alarm) {
        this.alarm = alarm;
    }



    public void execute() {
        alarm.activate(alarm.getId());
    }
}