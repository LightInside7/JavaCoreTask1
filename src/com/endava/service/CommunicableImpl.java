package com.endava.service;

import com.endava.enums.Status;
import com.endava.model.Human;
import com.endava.utils.CommunicableUtils;

public class CommunicableImpl implements Communicable {

    public void sendMessage(Human sender, Human receiver) {
        sender.setStatus(Status.ONLINE);
        System.out.println(sender.getName() + " Статус: " + sender.getStatus());

        if (CommunicableUtils.privilageOptions(sender, receiver) == false) {
            System.out.println("Вы не имеет доступ к данному чату или произошла ошибка идентификации");
        } else if (CommunicableUtils.privilageOptions(sender, receiver) == true) {
            CommunicableUtils.verifingStatus(receiver);
        }
    }
}

