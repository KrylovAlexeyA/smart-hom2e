package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room implements IActionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    public Light getLightById(String objectId) {
        for (Light light : getLights())
            if (light.getId().equals( objectId)) {
                return light;
            }
        return null;
    }

    @Override
    public void executeAction(IAction action) {
        action.execute(this);
        for (Door door : doors) {
            door.executeAction(action);
        }
        for (Light light: lights) {
            light.executeAction(action);
        }
    }


}



