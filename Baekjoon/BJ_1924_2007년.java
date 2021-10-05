/**
 * @ BJ 1924 2007년
 * @ prob : https://www.acmicpc.net/problem/1924
 */

import java.util.Scanner;

public class BJ_1924_2007년 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"}; 
        int month = sc.nextInt(), day = sc.nextInt();

        int gap = 0;
        for(int i = 0; i < month-1; i++) {
            gap += daysPerMonth[i];
        }
        gap += day - 1;
        
        System.out.println(week[gap % 7]);
        

        sc.close();
    }
}

// 다른 풀이 1
// 월별 일 수 대신 각 월별 누계 일 수 % 7 한 값을 미리 배열로 선언
// month = 1 -> 1월 이전은 없음
// month = 2 -> 1월까지의 누계 일 수 % 7
// month = 3 -> 2월까지의 누계 일 수 % 7
// month = 4 -> 13월까지의 누계 일 수 % 7

// int[] cumulativeRemainDays = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
// String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"}; 
//
// System.out.println(week[(cumulativeRemainDays[month-1] + day) % 7]);