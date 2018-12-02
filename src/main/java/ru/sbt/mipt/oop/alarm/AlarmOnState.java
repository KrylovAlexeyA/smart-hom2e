package ru.sbt.mipt.oop.alarm;

public class AlarmOnState implements IAlarmState {
    private Signal signal;


    public AlarmOnState(Signal signaling) {
        this.signal = signaling;
        System.out.println( "ALARM!");
    }

    @Override
    public void changeState(IAlarmState state) {
        signal.changeState(state);
    }

    @Override
    public void activate(String code) {
        System.out.println("ALARM! Someone try to change code!");
    }

    @Override
    public void deactivate(String code) {
        if (signal.checkCodeConcept(code)){
            signal.changeState(new DeactivatedState(signal));
            System.out.println("Signaling disabled");
        }
        System.out.println("ALARM! Wrong code!");
    }

    @Override
    public void setToAlarm() {

    }
}
