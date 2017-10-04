package com.endava.main;

import com.endava.model.Human;
import com.endava.model.Intern;
import com.endava.service.CommunicableImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Human i1 = new Intern("Ilia", 22);
        Human i2 = new Intern("Ivan", 32);
        CommunicableImpl comm = new CommunicableImpl();
        comm.sendMessage(i1, i2);
    }
}
