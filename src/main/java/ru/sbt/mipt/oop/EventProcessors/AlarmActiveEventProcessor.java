package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.ActivatedState;

public class AlarmActiveEventProcessor implements IEventProcessor {

    private IEventProcessor eventProcessor;

    public AlarmActiveEventProcessor(IEventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }


    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (smartHome.getAlarmState() instanceof ActivatedState){
            System.out.println("Alarm is activated!!!");
            smartHome.getAlarm().danger();
        } else {
            eventProcessor.processEvent(smartHome, event);
        }
    }
}
