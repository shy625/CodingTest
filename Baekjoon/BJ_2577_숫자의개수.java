/**
 * @ BJ 2577 숫자의 개수
 * @ prob : https://www.acmicpc.net/problem/2577
 */

import java.util.Scanner;

public class BJ_2577_숫자의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mul = sc.nextInt() * sc.nextInt() * sc.nextInt();
        int[] count = new int[10];

        String s = Integer.toString(mul);
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch-48]++;
            // String ch = s.charAt(i) + "";
            // count[Integer.valueOf(ch)]++;
        }

        for(int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }

        sc.close();
    }
}

// 다른 풀이 1
// 숫자로 처리하는 방법

// while(mul != 0) {
//     count[mul%10]++;
//     mul /= 10;
// }