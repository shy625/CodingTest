/**
 * @ BJ 10872 팩토리얼
 * @ prob : https://www.acmicpc.net/problem/10872
 */

import java.util.Scanner;

public class BJ_10872_팩토리얼 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        int factorial = 1;
        for(int i = 1; i <= n; i++) {
            factorial *= i;
        }
        
        System.out.println(factorial);
    }
}