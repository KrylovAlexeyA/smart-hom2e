package ru.sbt.mipt.oop.alarm;


public class ActivatedState implements IAlarmState {
    @Override
    public IAlarmState activate(int code, int password) {

        System.out.println("Alarm has already activated");

        return this;
    }

    @Override
    public IAlarmState deactivate(int code, int password) {
        if (code == password) {

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
    public boolean activated()
    {
        return true;
    }
}
