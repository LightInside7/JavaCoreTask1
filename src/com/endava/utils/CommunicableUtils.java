package com.endava.utils;

import com.endava.enums.Status;
import com.endava.model.Human;
import com.endava.model.Intern;
import com.endava.model.Mentor;

import java.time.LocalTime;
import java.util.Random;

public class CommunicableUtils {

    private static LocalTime isOnline() {
        return LocalTime.of(9, 00);
    }

    private static LocalTime isBusy() {
        return LocalTime.of(14, 00);
    }

    private static LocalTime isAway() {
        return LocalTime.of(17, 00);
    }

    private static LocalTime isOffline() {
        return LocalTime.of(21, 00);
    }

    public static boolean privilageOptions(Human sender, Human reciever) {
        if (sender instanceof Intern && reciever instanceof Mentor) {
            return false;
        } else if (sender instanceof Intern && reciever instanceof Intern) {
            return true;
        }
        return false;
    }

    private static void checkingTime(Human reciever) {
        LocalTime randomTime = getRandomTime();
        System.out.println(randomTime);
        if (randomTime.isAfter(isOnline()) && randomTime.isBefore(isBusy())) {
            reciever.setStatus(Status.ONLINE);
        } else if (randomTime.isAfter(isBusy()) && randomTime.isBefore(isAway())) {
            reciever.setStatus(Status.BUSY);
        } else if (randomTime.isAfter(isAway()) && randomTime.isBefore(isOffline())) {
            reciever.setStatus(Status.AWAY);
        } else if (randomTime.isBefore(isOnline()) || randomTime.isAfter(isOffline())) {
            reciever.setStatus(Status.OFFLINE);
        }
    }

    private static LocalTime getRandomTime() {
        Random random = new Random();
        return LocalTime.of((random.nextInt(24) + 0), random.nextInt(60) + 0);
    }

    public static void verifingStatus(Human reciever) {
        while (true) {
            checkingTime(reciever);
            switch (reciever.getStatus()) {
                case ONLINE:
                    System.out.println("Статус: " + reciever.getStatus() + ": - " + reciever.getName() + " отвечает " + reciever.getName() + " сообщением: " + "Hey!");
                    System.out.println("***Общение состоялось");
                    break;
                case AWAY:
                    System.out.println("Статус: " + reciever.getStatus() + ": - " + reciever.getName() + " сейчас не на месте, попробуйте позже ");
                    try {
                        Thread.sleep(Status.AWAY.getDelay());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                case BUSY:
                    System.out.println("Статус: " + reciever.getStatus() + ": - " + reciever.getName() + " сейчас занят и не принимает сообщения, попробуйте позже ");
                    try {
                        Thread.sleep(Status.BUSY.getDelay());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                case OFFLINE:
                    System.out.println("Статус: " + reciever.getStatus() + ": - " + reciever.getName() + " сейчас не принимает сообщения по причине выключенного компьютера, попробуйте в другое время");
                    try {
                        Thread.sleep(Status.OFFLINE.getDelay());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
            }
            break;
        }
    }
}
