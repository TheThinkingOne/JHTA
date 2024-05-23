import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {

    public static void makeCalender(int year, int month) {
        LocalDate localDate = LocalDate.of(year, month, 1);
        int lastDay = localDate.lengthOfMonth();
        // 무슨요일부터 시작하는지 알아야 함
        int day = localDate.getDayOfWeek().getValue();

        System.out.println("3월은 무슨 요일에서 시작하는가?");
        int date = 1;

        System.out.println("일\t월\t화\t수\t목\t금\t토");

        for (int i=0; i<day%7; i++) {
            System.out.printf("\t");
        }
        for (int i=0; i<lastDay; i++, date++) {
            System.out.printf("%02d\t",date);
            day++;
            if(day%7==0) System.out.println();
        }

    }

    public static void main(String[] args) {
        makeCalender(2024,3);
//        LocalDate today = LocalDate.now();
//        Month month = today.getMonth();
//        int numOfMonth = month.getValue();
//        System.out.println(today.getYear()+"-"+today.getMonth().getValue()+"-"+today.getDayOfMonth()
//        +"  " +today.getDayOfWeek().getValue());
//
//        LocalDate xmas = LocalDate.of(2024,12,25);
//        System.out.println(xmas);
//
//        LocalDate election = LocalDate.of(2024,04,10);
//        System.out.println(election);
//
//        LocalTime currentTime = LocalTime.now();
//        System.out.println(currentTime);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
        System.out.println(now.format(dateTimeFormatter));


    }
}
