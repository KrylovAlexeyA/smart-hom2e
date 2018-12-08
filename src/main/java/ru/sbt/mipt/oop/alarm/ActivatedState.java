package ru.sbt.mipt.oop.alarm;


public class ActivatedState implements IAlarmState {
    @Override
    public IAlarmState activate(String inputCode, String password) {
        System.out.println("Alarm is already activated");
        return this;
    }

    @Override
    public IAlarmState deactivate(String inputCode, String password) {
        if (inputCode.equals(password)) {
            System.out.println("Alarm is deactivated");
            return new DeactivatedState();
        } else {
            return danger();
        }
    }

    @Override
    public IAlarmState danger() {
        System.out.println("Alarm is in danger!!!");
        return new DangerSignalState();
    }

    @Override
    public boolean isActivated() {
        return true;
    }
}
