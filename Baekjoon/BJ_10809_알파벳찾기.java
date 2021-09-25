/**
 * @ BJ 10809 알파벳 찾기
 * @ prob : https://www.acmicpc.net/problem/10809
 */

import java.util.Scanner;

public class BJ_10809_알파벳찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        for(int i = 97; i <= 122; i++) {    // ASCII : 'a' = 97, 'z' = 122
            int pos = s.indexOf(i);
            System.out.print(pos + " ");
        }

        sc.close();
    }
}