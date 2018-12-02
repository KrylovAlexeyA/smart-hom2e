package ru.sbt.mipt.oop.alarm;

public interface IAlarmState {

    void changeState( IAlarmState state);

    void activate(String code);
    void deactivate(String code);

    void setToAlarm();

}