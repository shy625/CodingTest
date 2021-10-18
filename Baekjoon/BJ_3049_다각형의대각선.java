/**
 * @ BJ 3049 다각형의 대각선
 * @ prob : https://www.acmicpc.net/problem/3049
 */

import java.util.Scanner;

public class BJ_3049_다각형의대각선 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = n * (n-1) * (n-2) * (n-3) / 24;    // nC4
        System.out.println(result);

        sc.close();
    }
}

// 해설 : https://www.acmicpc.net/board/view/3039