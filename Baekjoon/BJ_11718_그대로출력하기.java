/**
 * @ BJ 11718 그대로 출력하기
 * @ prob : https://www.acmicpc.net/problem/11718
 */

import java.util.Scanner;

public class BJ_11718_그대로출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        sc.close();
    }
}