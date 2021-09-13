/**
 * @ BJ 10871 X보다 작은 수
 * @ prob : https://www.acmicpc.net/problem/10871
 */

import java.util.Scanner;

public class BJ_10871_X보다작은수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), x = sc.nextInt();
        // int[] arr = new int[n];
        int a = 0;

        // for(int i = 0; i < n; i++) {
        //     arr[i] = sc.nextInt();
        // }

        for(int i = 0; i < n; i++) {
            // if(arr[i] < x) {
            if((a = sc.nextInt()) < x) {
                System.out.print(a + " ");
            }
        }

        sc.close();
    }
}