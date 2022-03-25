/**
 * BJ 2292 벌집
 * @ prob : https://www.acmicpc.net/problem/2292
 * @ level : B2
 */

import java.util.Scanner;

public class BJ_2292_벌집 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        int a = 1;
        int i = 1;
        while(true){
            if(N <= a) {
                System.out.println(i);
                break;
            }
            a += i++ * 6;
        }

        sc.close();
    }
}

// 풀이 1
// 중심으로부터 멀어질수록 육각형 테두리에 증가하는 개수 규칙 확인 -> 등차수열