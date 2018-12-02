package ru.sbt.mipt.oop;

public class Door implements IActionable {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
    public boolean getIsOpen(){
        return isOpen;
    }

    @Override
    public void executeAction(IAction action) {
        action.execute(this);
    }

}
