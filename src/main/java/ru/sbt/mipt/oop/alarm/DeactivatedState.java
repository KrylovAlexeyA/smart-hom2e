package ru.sbt.mipt.oop.alarm;


public class DeactivatedState implements IAlarmState {

    @Override
    public IAlarmState activate(String inputCode, String password) {
        if (inputCode.equals(password)) {
            System.out.println("Alarm was activated");
            return new ActivatedState();
        } else {
            return danger();
        }
    }

    @Override
    public IAlarmState deactivate(String inputCode, String password) {

        System.out.println("Alarm have already deactivated");


        return this;
    }

    @Override
    public IAlarmState danger() {
        System.out.println("Alarm is in danger state");
        return new DangerSignalState();
    }
}
