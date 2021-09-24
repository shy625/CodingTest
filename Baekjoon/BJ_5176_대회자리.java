/**
 * @ BJ 5176 대회 자리
 * @ prob : https://www.acmicpc.net/problem/5176
 */

import java.util.*;

public class BJ_5176_대회자리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int peopleNum = sc.nextInt(), seatNum = sc.nextInt();
            boolean[] cannotSit = new boolean[seatNum];
            int failCount = 0;
            for(int j = 0; j < peopleNum; j++) {
                int seatNo = sc.nextInt() - 1;
                if(cannotSit[seatNo]) {
                    failCount++;
                } else {
                    cannotSit[seatNo] = true;
                }
            }
            System.out.println(failCount);
        }

        sc.close();
    }
}

// 다른 풀이 1
// HashSet을 이용한 풀이

// int t = sc.nextInt();
// for(int i = 0; i < t; i++) {
//     int peopleNum = sc.nextInt(), seatNum = sc.nextInt();
//     Set<Integer> set = new HashSet<>();
//     for(int j = 0; j < peopleNum; j++) {
//         set.add(sc.nextInt());
//     }
//     System.out.println(peopleNum - set.size());
// }