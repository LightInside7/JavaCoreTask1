package com.endava.service;

import com.endava.model.Human;

public interface Communicable {
    void sendMessage(Human sender, Human reciever);
}