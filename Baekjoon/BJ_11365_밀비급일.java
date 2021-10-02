/**
 * @ BJ 11365 !밀비 급일
 * @ prob : https://www.acmicpc.net/problem/11365
 */

import java.util.Scanner;

public class BJ_11365_밀비급일 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "";
        while(!(str = sc.nextLine()).equals("END")) {
            StringBuilder sb = new StringBuilder(str);
            sb = sb.reverse();
            System.out.println(sb.toString());
        }

        sc.close();
    }
}