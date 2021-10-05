/**
 * @ BJ 2948 2009년
 * @ prob : https://www.acmicpc.net/problem/2948
 */

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Scanner;

public class BJ_2948_2009년 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int day = sc.nextInt(), month = sc.nextInt();

        String[] week = {"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};

        LocalDate from = LocalDate.of(2009, 1, 1);
        LocalDate to = LocalDate.of(2009, month, day);

        long gap = ChronoUnit.DAYS.between(from, to);

        System.out.println(week[(int)gap % 7]);

        sc.close();
    }
}

// 다른 풀이 1
// LocalDate의 getDayOfWeek() 활용
// getDayOfWeek() : 요일을 반환 ex) MONDAY, SUNDAY
// getDayOfWeek().getValue() : 요일을 값으로 반환 ex) MON = 1, SUN = 7

// String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
// System.out.println(week[to.getDayOfWeek().getValue()-1]);

// 다른 풀이 2
// Calendar 클래스 이용

// Calendar cal = Calendar.getInstance();
// cal.set(year, month-1, day-1);
// System.out.println(week[cal.get(Calendar.DAY_OF_WEEK)-1]);