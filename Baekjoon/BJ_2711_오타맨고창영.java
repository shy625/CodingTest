/**
 * @ BJ 2711 오타맨 고창영
 * @ prob : https://www.acmicpc.net/problem/2711
 */

import java.util.Scanner;

public class BJ_2711_오타맨고창영 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int pos = sc.nextInt();
            StringBuilder sb = new StringBuilder(sc.next());

            sb = sb.deleteCharAt(pos-1);

            System.out.println(sb.toString());
        }

        sc.close();
    }
}

// 다른 풀이 1
// substring 이용 -> 오타난 부분만 빼고 이어 붙이기

// int pos = sc.nextInt();
// String str = sc.next();
// str = str.substring(0, pos-1) + str.substring(pos);
// System.out.println(str);