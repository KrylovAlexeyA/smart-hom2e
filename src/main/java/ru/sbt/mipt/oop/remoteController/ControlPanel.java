package ru.sbt.mipt.oop.remoteController;


import java.util.HashMap;
import java.util.Map;


public class ControlPanel implements IRemoteController {

    private Map<String, IRCcommand> buttons;

    public ControlPanel() {

        buttons = new HashMap<>();
    }

    public void setingCommand(String buttonCode,  IRCcommand command) {

        buttons.put(buttonCode,command);
    }

    @Override
    public void onButtonPressed(String buttonCode) {

        buttons.get(buttonCode).execute();
    }
}
