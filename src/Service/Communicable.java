package Service;

import Model.Human;

/**
 * Created by icebotari on 9/27/2017.
 */
public interface Communicable {
    void sendMessage(Human sender, Human reciever, String message);
}