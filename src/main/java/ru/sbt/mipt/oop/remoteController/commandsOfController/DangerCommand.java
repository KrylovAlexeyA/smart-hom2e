package ru.sbt.mipt.oop.remoteController.commandsOfController;

import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.remoteController.IRCcommand;



public class DangerCommand implements IRCcommand {

    private Alarm alarm;

    public DangerCommand(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.danger();
    }
}