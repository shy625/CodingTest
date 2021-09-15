/**
 * @ BJ 10797 10부제
 * @ prob : https://www.acmicpc.net/problem/10797
 */

import java.util.Scanner;

public class BJ_10797_10부제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int day = sc.nextInt(), count = 0;
        for(int i = 0; i < 5; i++) {
            if(sc.nextInt() == day) {
                count++;
            }
        }
        System.out.println(count);

        sc.close();
    }
}