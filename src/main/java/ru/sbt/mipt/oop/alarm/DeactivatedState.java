package ru.sbt.mipt.oop.alarm;


public class DeactivatedState implements IAlarmState {

    @Override
    public IAlarmState activate(int code, int password) {
        if (code == password) {
            System.out.println("Alarm was activated");
            return new ActivatedState();
        } else {
            return danger();
        }
    }

    @Override
    public IAlarmState deactivate(int code, int password) {

        System.out.println("Alarm have already deactivated");


        return this;
    }

    @Override
    public IAlarmState danger() {
        System.out.println("Alarm is in danger state");
        return new DangerSignalState();
    }
}
