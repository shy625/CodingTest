/**
 * @ BJ 2747 피보나치 수
 * @ prob : https://www.acmicpc.net/problem/2747
 */

import java.util.Scanner;

public class BJ_2747_피보나치수 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        
        int f0 = 0, f1 = 1, f2 = 1;
        for(int i = 3; i <= n; i++) {
            f0 = f1;
            f1 = f2;
            int tmp = f0 + f1;
            f2 = tmp;
        }
        
        System.out.println(n == 0 ? f0 : (n == 1 ? f1 : f2));
    }
}

// 다른 풀이 1
// 동일 로직 다른 코드

// for(int i = 0; i <= n; i++) {
//     if(i == 0) {
//         f2 = f0;
//     } else if(i == 1) {
//         f2 = f1;
//     } else {
//         f2 = f0 + f1;
//         f0 = f1;
//         f1 = f2;
//     }
// }
// System.out.println(f2);
