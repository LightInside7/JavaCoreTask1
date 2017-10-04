package com.endava.model;

import com.endava.enums.Status;

public class Mentor extends Human {

    public Mentor(String name, int age) {
        super(name, age, Status.ONLINE);
    }

}
