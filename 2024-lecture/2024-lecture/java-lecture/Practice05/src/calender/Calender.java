package calender;

import java.util.Calendar;

public class Calender {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);

        if (hour >= 4 && hour <= 12) System.out.println("Good Morning");
        else if (hour >= 13 && hour <= 18) System.out.println("Good Evening");
        else System.out.println("Good Evening");

    }
}
