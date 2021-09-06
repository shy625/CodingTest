/**
 * @ BJ 5565 영수증
 * @ prob : https://www.acmicpc.net/problem/5565
 */

import java.util.Scanner;

public class BJ_5565_영수증 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int price = sc.nextInt();
        for(int i = 1; i < 10; i++) {
            price -= sc.nextInt();
        }
        System.out.println(price);

        sc.close();
    }
}

// 다른 풀이 1
// 입력 횟수 지정하는 대신 hasNext()로 체크하기

// while(sc.hasNext()) {}