package com.endava.enums;

public enum Status {
    ONLINE(0),
    AWAY(2000),
    BUSY(5000),
    OFFLINE(7000),;

    private int delay;

    Status(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
