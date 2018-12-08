package ru.sbt.mipt.oop.remoteController;






public interface IRemoteController {

    void onButtonPressed(String buttonCode); // код нажатой кнопки: “A”, “B”, “C”, “D”, “1”, “2”, “3”, “4”
}