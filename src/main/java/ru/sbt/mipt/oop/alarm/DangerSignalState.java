package ru.sbt.mipt.oop.alarm;


public class DangerSignalState implements IAlarmState {

    public DangerSignalState() {

        System.out.println("SMS:Attention, Danger");
    }

    @Override
    public IAlarmState activate(int code, int password) {

        System.out.println("Alarm is in danger state");

        return this;
    }

    @Override
    public IAlarmState deactivate(int code, int password) {
        if (code == password) {

            System.out.println("Alarm was deactivated");

            return new DeactivatedState();

        } else {

            return danger();
        }
    }

    @Override
    public IAlarmState danger() {
        System.out.println("Alarm is in danger state");
        return this;
    }

    @Override
    public boolean activated() {

        return true;
    }
}
