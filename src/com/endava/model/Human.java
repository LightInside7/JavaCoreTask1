package com.endava.model;

import com.endava.enums.Status;

public abstract class Human {
    private String name;
    private int age;
    private Status status;

    public Human(String name, int age, Status status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public void setName() {
        this.name = name;
    }

    public void setAge() {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }
}

