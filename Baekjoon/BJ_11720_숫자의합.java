/**
 * @ BJ 11720 숫자의 합
 * @ prob : https://www.acmicpc.net/problem/11720
 */

import java.util.Scanner;

public class BJ_11720_숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());
        String input = sc.nextLine();

        int[] numbers = new int[n];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = input.charAt(i) - '0';
        }

        int sum = 0;
        for(int i : numbers) {
            sum += i;
        }

        System.out.println(sum);
        
        sc.close();
    }
}

// 다른 풀이 1
// char -> int 변환하여 계산

// String input = sc.nextLine();
// int sum = 0;
// for(int i = 0; i < n; i++) {
//     sum += input.charAt(i) - '0';
// }

// char[] input = sc.nextLine().toCharArray();
// int sum = 0;
// for(int i = 0; i < n; i++) {
//     sum += input[i] - '0';
// }

// 다른 풀이 2
// String -> int 변환하여 계산

// String[] input = sc.nextLine().split("");
// int sum = 0;
// for(int i = 0; i < n; i++) {
//     sum += Integer.valueOf(input[i]);
// }