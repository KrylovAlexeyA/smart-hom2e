package ru.sbt.mipt.oop.alarm;


public interface IAlarmState {

    IAlarmState activate(String inputCode, String password);

    IAlarmState deactivate(String inputCode, String password);

    default boolean isActivated(){

        return false;
    }

    IAlarmState danger();

}
