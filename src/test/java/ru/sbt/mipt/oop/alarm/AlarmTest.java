package ru.sbt.mipt.oop.alarm;



import org.junit.Test;

import static org.junit.Assert.*;



public class AlarmTest {
    Alarm alarm = new Alarm(1234,16);

    @Test
    public void getId() {
        System.out.println("id test");
        assertEquals(16,alarm.getId());
        System.out.println("Ok");
    }

    @Test
    public void activate() {
        System.out.println("activate test");
        alarm.activate(1234);
        assertTrue(alarm.getState() instanceof ActivatedState);
        System.out.println("Ok");
    }

    @Test
    public void deactivate() {
        System.out.println("deactivate test");
        alarm.deactivate(1234);
        assertTrue(alarm.getState() instanceof DeactivatedState);
        System.out.println("Ok");
    }


}