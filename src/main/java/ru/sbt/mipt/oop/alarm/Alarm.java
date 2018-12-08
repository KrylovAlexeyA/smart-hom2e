package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.IAction;
import ru.sbt.mipt.oop.IActionable;
import ru.sbt.mipt.oop.IPrintable;

public class Alarm implements IActionable, IPrintable {


    private IAlarmState state;
    private final String id;
    private String password;


    public Alarm(String password, String id) {
        this.password = password;
        this.state = new DeactivatedState();
        this.id = id;
    }

    public String getId() {

        return id;
    }

    public void activate(String inputCode) {

        state = state.activate(inputCode, password);

    }

    public void deactivate(String inputCode){

        state = state.deactivate(inputCode, password);

    }

    public void danger() {

        state = state.danger();
    }

    public boolean isActivated(){

        return state.isActivated();
    }

    @Override
    public void printToSystemOut() {

        System.out.println("Alarm id: "+ getId());
    }

    @Override
    public void executeAction(IAction action) {

        action.execute(this);
    }
}
