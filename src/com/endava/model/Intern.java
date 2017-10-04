package com.endava.model;

import com.endava.enums.Status;

public class Intern extends Human {

    public Intern(String name, int age) {
        super(name, age, Status.ONLINE);
    }
}

