package Java;

import Model.Human;
import Model.Intern;
import Model.Mentor;
import Service.Communicable;
import Service.CommunicableImpl;

import java.io.IOException;

/**
 * Created by icebotari on 9/27/2017.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Human i1 = new Intern("Ilia", 22);
        Human i2 = new Intern("Ivan", 32);
//        Human i3 = new Mentor("Mentor1", 22);
        CommunicableImpl comm = new CommunicableImpl();
        comm.sendMessage(i1, i2, "Hello");
    }
}
