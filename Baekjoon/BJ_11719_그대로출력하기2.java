/**
 * @ BJ 11719 그대로 출력하기 2
 * @ prob : https://www.acmicpc.net/problem/11719
 */

import java.util.Scanner;

public class BJ_11719_그대로출력하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        sc.close();
    }
}