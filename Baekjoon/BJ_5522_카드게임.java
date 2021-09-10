/**
 * @ BJ 5522 카드 게임
 * @ prob : https://www.acmicpc.net/problem/5522
 */

import java.util.Scanner;

public class BJ_5522_카드게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        for(int i = 0; i < 5; i++) {
            sum += sc.nextInt();
        }
        System.out.println(sum);

        sc.close();
    }
}