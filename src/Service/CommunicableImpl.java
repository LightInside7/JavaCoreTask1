package Service;

import Enums.Status;
import Model.Human;
import Model.Intern;
import Model.Mentor;
import Test.Timetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CommunicableImpl {
    public String message;
    public Timetable t = new Timetable();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void sendMessage(Human sender, Human reciever, String message) {
        while(true){
            sender.setStatus(Status.ONLINE);
            System.out.println(sender.getName() + " Статус: " + sender.getStatus());
            System.out.println("Введите сообщение");

            try {
                message = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(sender instanceof Intern && reciever instanceof Mentor){
                System.out.println("You do not have access for this chat");
                break;
            }
            if(sender instanceof Intern && reciever instanceof Intern){//TODO

                if(t.getToday().isAfter(t.getOnline()) && t.getToday().isBefore(t.getAway())) {
                    reciever.setStatus(Status.ONLINE);
                }
                if(t.getToday().isAfter(t.getAway()) && t.getToday().isBefore(t.getBusy())){
                    reciever.setStatus(Status.AWAY);
                }
                if(t.getToday().isAfter(t.getBusy()) && t.getToday().isBefore(t.getOffline())){
                    reciever.setStatus(Status.BUSY);
                }
                if(t.getToday().isAfter(t.getOffline()) && t.getToday().isBefore(t.getOnline())){
                    reciever.setStatus(Status.OFFLINE);
                }

            }
            switch (reciever.getStatus()){
                case ONLINE:
                    System.out.println("");
                    System.out.println("Статус: " + reciever.getStatus() + ": - " + reciever.getName() + " отвечает " + reciever.getName() + " сообщением: " + "Hey!");
                    System.out.println("***Общение состоялось");
                    break;
                case AWAY:
                    System.out.println("");
                    System.out.println("Статус: " + reciever.getStatus() + ": - " + reciever.getName() + " сейчас не на месте, попробуйте позже ");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                case BUSY:
                    System.out.println("");
                    System.out.println("Статус: " + reciever.getStatus() + ": - " + reciever.getName() + " сейчас занят и не принимает сообщения, попробуйте позже ");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;

                case OFFLINE:
                    System.out.println("");
                    System.out.println("Статус: " + reciever.getStatus() + ": - " + reciever.getName() + " сейчас не принимает сообщения по причине выключенного компьютера, попробуйте в другое время");
                    break;

                }
                break;
            }
        }
    }

