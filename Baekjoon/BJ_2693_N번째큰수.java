/**
 * @ BJ 2693 N번째 큰 수
 * @ prob : https://www.acmicpc.net/problem/2693
 */

import java.util.*;

public class BJ_2693_N번째큰수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int[] arr = new int[10];
            for(int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(arr[7]);
        }

        sc.close();
    }
}