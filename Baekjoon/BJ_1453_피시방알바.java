/**
 * @ BJ 1453 피시방 알바
 * @ prob : https://www.acmicpc.net/problem/1453
 */

import java.util.Scanner;

public class BJ_1453_피시방알바 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] isUnAvailable = new boolean[101];     // isTaken 이라는 변수명이 더 나을듯! 부정형을 지양하자

        int n = sc.nextInt();
        int falseCount = 0;     // rejectCount 가 더 의미가 잘 드러나는듯
        for(int i = 0; i < n; i++) {
            int seatNum = sc.nextInt();
            if(isUnAvailable[seatNum]) {
                falseCount++;
            } else {
                isUnAvailable[seatNum] = true;
            }
        }
        System.out.println(falseCount);

        sc.close();
    }
}