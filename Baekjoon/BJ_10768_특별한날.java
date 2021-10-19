/**
 * @ BJ 10768 특별한 날
 * @ prob : https://www.acmicpc.net/problem/10768
 */

import java.util.Scanner;

public class BJ_10768_특별한날 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        int day = sc.nextInt();

        if((month < 2) || (month == 2 && day < 18)) {
            System.out.println("Before");
        } else if(month == 2 && day == 18) {
            System.out.println("Special");
        } else {
            System.out.println("After");
        }

        sc.close();
    }
}