/**
 * @ BJ 10952 A+B - 5
 * @ prob : https://www.acmicpc.net/problem/10952
 */

import java.util.Scanner;

public class BJ_10952_A더하기B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int sum = sc.nextInt() + sc.nextInt();
            if(sum == 0) {
                break;
            }
            System.out.println(sum);
        }
        
        sc.close();
    }
}

// 다른 풀이 1
// for문 선언부 내에서 조건 체크 -> 아래 풀이를 풀어 쓰면 위 풀이

// for(int sum; (sum = sc.nextInt() + sc.nextInt()) != 0;) {
//     System.out.println(sum);
// }
