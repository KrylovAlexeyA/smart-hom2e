package ru.sbt.mipt.oop;

import org.junit.*;
import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

public class DoorEventProcessorTestRun {

    public static void main(String[] args) {
        System.out.println("Running DoorEventProcessorTest");
        Result results = JUnitCore.runClasses(DoorEventProcessorTest.class);
        for (Failure failure : results.getFailures()){
            System.out.println("Тест не пройден: "+ failure);
        }
    }


}
