package ru.sbt.mipt.oop.alarm;

public class ActivatedState implements IAlarmState {
    Signal signal;

    public ActivatedState(Signal signaling, String code) {
        this.signal = signal;
        this.signal.setSecretCode(code);
        System.out.println( "Signal is activated");
    }

    @Override
    public void changeState( IAlarmState state) {
        signal.changeState(state);
    }

    @Override
    public void activate(String code) {
        System.out.println("Signaling is already active! Any attempt to change code is interpreting as invasion!");
        changeState(new AlarmOnState(signal));
    }

    @Override
    public void deactivate(String code) {
        if (signal.checkCodeConcept(code)) {
            System.out.println("Signaling successfully deactivated!");
            changeState(new DeactivatedState(signal));
        } else {
            System.out.println("Wrong secret code!");
            changeState(new AlarmOnState(signal));
        }
    }

    @Override
    public void setToAlarm() {
        System.out.println("Unacceptable behaviour!");
        changeState(new AlarmOnState(signal));
    }

}
