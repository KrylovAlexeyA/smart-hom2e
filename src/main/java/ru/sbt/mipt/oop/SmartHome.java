package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.ActivatedState;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.IAlarmState;
import ru.sbt.mipt.oop.simpleElements.Light;
import ru.sbt.mipt.oop.simpleElements.Room;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome {
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    private Alarm alarm = new Alarm(1234,1234);

    public void turnOffLights() {
        for (Room homeRoom : getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                SensorCommandExecutor.executeCommand(command);
            }
        }
    }
    public void turnOnLights() {
        for (Room homeRoom : getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(true);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_ON, light.getId());
                SensorCommandExecutor.executeCommand(command);
            }
        }
    }


    public void executeAction(IAction action) {
        action.execute(this);
        for (Room room : rooms) {
            room.executeAction(action);
        }
    }
    public void setAlarm(Alarm alarm){
        this.alarm = alarm;
    }
    public Alarm getAlarm(){
        return alarm;
    }
    public IAlarmState getAlarmState(){
        return alarm.getState();
    }

}
