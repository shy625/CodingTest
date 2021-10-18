/**
 * @ BJ 3059 등장하지 않는 문자의 합
 * @ prob : https://www.acmicpc.net/problem/3059
 */

import java.util.Scanner;

public class BJ_3059_등장하지않는문자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            String input = sc.next();
            boolean[] isExisted = new boolean[26];
            int sum = 0;
            for(int j = 0; j < input.length(); j++) {
                isExisted[input.charAt(j) - 'A'] = true;
            }
            for(int j = 0; j < isExisted.length; j++) {
                if(!isExisted[j]) {
                    sum += j + 'A';
                }
            }
            System.out.println(sum);
        }

        sc.close();
    }
}