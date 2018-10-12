package ru.sbt.mipt.oop;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class HallDoorEventProcessorTestRun {

    public static void main(String[] args) {
        System.out.println("Running HallDoorEventProcessorTest");
        Result results = JUnitCore.runClasses(HallDoorEventProcessorTest.class);
        for (Failure failure : results.getFailures()){
            System.out.println("Тест не пройден: "+ failure);
        }
    }


}
