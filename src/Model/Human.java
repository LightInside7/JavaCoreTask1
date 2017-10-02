package Model;

import Enums.Status;
import Test.Timetable;

/**
 * Created by icebotari on 9/27/2017.
 */
public abstract class Human {
    String name;
    int age;

    Status status;

    Timetable t = new Timetable();

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
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

