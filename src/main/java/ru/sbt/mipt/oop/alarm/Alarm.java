package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.IAction;
import ru.sbt.mipt.oop.IActionable;
import ru.sbt.mipt.oop.IPrintable;

public class Alarm implements IActionable, IPrintable {


    private IAlarmState state;
    private final int id;
    private int password;


    public Alarm(int password, int id) {
        this.password = password;
        this.state = new DeactivatedState();
        this.id = id;
    }

    public IAlarmState getState(){
        return state;
    }

    public int getId() {

        return id;
    }

    public void activate(int code) {

        state = state.activate(code, password);

    }

    public void deactivate(int code){

        state = state.deactivate(code, password);

    }

    public void danger() {

        state = state.danger();
    }

    public boolean activated(){

        return state.activated();
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
