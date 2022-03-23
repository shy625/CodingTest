/**
 * BJ 1436 영화감독 숌
 * @ prob : https://www.acmicpc.net/problem/1436
 * @ level : S5
 */

import java.util.Scanner;

public class BJ_1436_영화감독숌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int count = 0;
        int num = 666;
        while (true) {
            if((num + "").contains("666")) {
                count++;
            }
            if(count == N) {
                System.out.println(num);
                break;
            }
            num++;
        }

        sc.close();
    }
}

// 다른 풀이 1
// 규칙을 이용하여 풀이
// https://www.acmicpc.net/source/14504553