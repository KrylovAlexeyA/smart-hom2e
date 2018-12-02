package ru.sbt.mipt.oop.alarm;


public class Signal {

    private IAlarmState state = new DeactivatedState(this);


    void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }


    private String secretCode = "1234";

    public Signal() {
    }


    public Signal(String secretCode) {
        this.secretCode = secretCode;
    }

    void changeState(IAlarmState state) {
        this.state = state;
    }

    public IAlarmState getState() {
        return state;
    }

    public void activate(String code){
        state.activate(code);
    }

    public void deactivate (String code) {
        state.deactivate(code);
    }

    public boolean checkCodeConcept(String code) {
        return this.secretCode.equals(code);
    }

    public void setToAlarm() {
        state.setToAlarm();
    }
}
