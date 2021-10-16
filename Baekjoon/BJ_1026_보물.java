/**
 * @ BJ 1026 보물
 * @ prob : https://www.acmicpc.net/problem/1026
 */

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1026_보물 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        for(int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            arrB[i] = sc.nextInt();
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);
        // 문제에는 B 배열을 재배열하지 말라고 되어 있지만 어차피 출력은 최종적으로 계산한 결과만 하기 때문에 B 배열을 재배열해도 상관 X

        int result = 0;
        for(int i = 0; i < n; i++) {
            result += arrA[i] * arrB[n-1-i];
        }
        
        System.out.println(result);

        sc.close();
    }
}