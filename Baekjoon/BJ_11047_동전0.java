/**
 * @ BJ 11047 동전 0
 * @ prob : https://www.acmicpc.net/problem/11047
 */

import java.util.Scanner;

public class BJ_11047_동전0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), value = sc.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < coins.length; i++) {
            coins[i] = sc.nextInt();
        }

        int count = 0;
        for(int i = coins.length-1; i >= 0; i--) {
            // if(value == 0) {    // value가 0이 되면 어차피 아래 조건식에 걸리지 않으므로 굳이 체크할 필요 x
            //     break;          // 완료 되면 남은 동전들에 대해 불필요한 연산을 추가로 할 필요 없이 바로 반복문을 빠져나온다는 장점은 있음
            // }
            // if(value / coins[i] == 0) { // 굳이 필요없는 부분
            //     continue;
            // } else {  
            if(value / coins[i] > 0) {
                count += value / coins[i];
                value %= coins[i];
            }
        }
        System.out.println(count);

        sc.close();
    }
}