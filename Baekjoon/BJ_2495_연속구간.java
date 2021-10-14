/**
 * @ BJ 2495 연속 구간
 * @ prob : https://www.acmicpc.net/problem/2495
 */

import java.util.Scanner;

public class BJ_2495_연속구간 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
            char num = ' ';
            int count = 1;
            int max = 1;
            String input = sc.nextLine();
            for(int j = 0; j < input.length(); j++) {
                if(input.charAt(j) != num) {
                    num = input.charAt(j);
                    count = 1;
                } else {
                    count++;
                    max = Math.max(max, count);
                }
            }
            System.out.println(max);
        }

        sc.close();
    }
}

// 다른 풀이 1
// 이전 숫자를 따로 저장하지 않고 charAt()의 인덱스로만 해결

// for(int j = 1; j < input.length(); j++) {
//     if(input.charAt(j-1) != input.charAt(j)) {
//         count = 1;
//     } else {
//         count++;
//         max = Math.max(max, count);
//     }
// }