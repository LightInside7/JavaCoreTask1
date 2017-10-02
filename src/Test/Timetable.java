package Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Timetable {

    public LocalTime today = LocalTime.now();
    public LocalTime Online = LocalTime.of(9, 00,00);
    public LocalTime Away = LocalTime.of(12, 00, 00);
    public LocalTime Busy = LocalTime.of(14, 00, 00);
    public LocalTime Offline = LocalTime.of(17, 00, 00);

    public LocalTime getToday(){
        return today;
    }
    public LocalTime getOnlineTime(){
        return Online;
    }
    public LocalTime getAway() {
        return Away;
    }
    public LocalTime getOnline() {
        return Online;
    }

    public LocalTime getBusy() {
        return Busy;
    }

    public LocalTime getOffline() {
        return Offline;
    }
}
