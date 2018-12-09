package ru.sbt.mipt.oop.alarm;


public interface IAlarmState {

    IAlarmState activate(int Code, int password);

    IAlarmState deactivate(int Code, int password);

    default boolean activated(){

        return false;
    }

    IAlarmState danger();

}
