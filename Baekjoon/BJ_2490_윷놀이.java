/**
 * @ BJ 2490 윷놀이
 * @ prob : https://www.acmicpc.net/problem/2490
 */

import java.util.Scanner;

public class BJ_2490_윷놀이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
            int sum = 0;
            for(int j = 0; j < 4; j++) {
                sum += sc.nextInt();
            }
            switch(sum) {
                case 3 :    // 도
                    System.out.println('A');
                    break;
                case 2 :    // 개
                    System.out.println('B');
                    break;
                case 1 :    // 걸
                    System.out.println('C');
                    break;
                case 0 :    // 윷
                    System.out.println('D');
                    break;
                case 4 :    // 모
                    System.out.println('E');
                    break;
            }
        }

        sc.close();
    }
}

// 다른 풀이 1
// 도, 개, 걸, 윷, 모를 미리 배열로 선언

// char[] list = {'D', 'C', 'B', 'A', 'E'};
// for(int i = 0; i < 3; i++) {
//     int sum = 0;
//     for(int j = 0; j < 4; j++) {
//         sum += sc.nextInt();
//     }
//     System.out.println(list[sum]);
// }