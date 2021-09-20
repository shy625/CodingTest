/**
 * @ BJ 10818 최소, 최대
 * @ prob : https://www.acmicpc.net/problem/10818
 */

import java.util.Arrays;
import java.util.Scanner;

public class BJ_10818_최소최대 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = -1000000, min = 1000000;
        for(int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if(input > max) {
                max = input;
            }
            if(input < min) {
                min = input;
            }
        }
        System.out.println(min + " " + max);;

        sc.close();
    }
}

// 다른 풀이 1
// Arrays.sort() 이용

// int n = sc.nextInt();
// int[] arr = new int[n];
// for(int i = 0; i < arr.length; i++) {
//     arr[i] = sc.nextInt();
// }
// Arrays.sort(arr);
// System.out.println(arr[0] + " " + arr[arr.length-1]);