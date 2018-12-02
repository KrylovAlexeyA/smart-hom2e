package ru.sbt.mipt.oop.alarm;


public class DeactivatedState implements IAlarmState {
    private Signal signal;

    public DeactivatedState(Signal signal) {
        this.signal = signal;
        this.signal.setSecretCode("0000");
        System.out.println( "Signaling disabled");
    }

    @Override
    public void changeState(IAlarmState state) {
        signal.changeState(state);
    }

    @Override
    public void activate(String code) {
        signal.changeState(new ActivatedState(signal,code));
        System.out.println("Signaling was activated. The Home is under control!");
    }

    @Override
    public void deactivate(String code) {
        System.out.println( " Signaling is already disabled");
    }

    @Override
    public void setToAlarm() {
        System.out.println( "Something goes wrong...");
        changeState(new AlarmOnState(signal));
    }
}
