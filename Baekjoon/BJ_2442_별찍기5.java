/**
 * @ BJ 2442 별 찍기 - 5
 * @ prob : https://www.acmicpc.net/problem/2442
 */

import java.util.Scanner;

public class BJ_2442_별찍기5 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        for(int i = 1; i <= n; i++) {
            for(int x = n-i; x > 0; x--) {
                System.out.print(" ");
            }
            for(int y = 1; y <= 2*i-1; y++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

// 다른 풀이 1
// 빈 문자열에 붙여가면서 출력

// String s = "";
// for(int i = 0; i < n; i++) {
//     System.out.printf("%"+(n > 1 ? n - 1 : "")+"s%s\n", s, s += "*");
// }