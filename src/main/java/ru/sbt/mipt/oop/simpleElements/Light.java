package ru.sbt.mipt.oop.simpleElements;

import ru.sbt.mipt.oop.IAction;
import ru.sbt.mipt.oop.IActionable;

public class Light implements IActionable {
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        this.isOn = on;
    }

    @Override
    public void executeAction(IAction action) {
        action.execute(this);
    }
}
