/*
    @ BJ 1977 완전제곱수
    @ prob : https://www.acmicpc.net/problem/1977
*/

import java.util.Scanner;

public class BJ_1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = 0, n = 0;

        m = sc.nextInt();
        n = sc.nextInt();

        int i = 0;
        int min = 10000, sum = 0;
        while(true) {
            //  완전제곱수를 기준으로 비교
            int i2 = i * i;
            //  완전제곱수가 n 또는 10000 보다 큰 경우
            if(i2 > n || i2 > 10000) {
                break;
            }
            //  완전제곱수가 m 이상 n 이하인 경우
            if(m <= i2 && i2 <= n) {
                if(i2 <= min) {
                    min = i2;
                }
                sum += i2;
            }
            i++;
        }

        if(sum <= 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}