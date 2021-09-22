/**
 * @ BJ 2750 수 정렬하기
 * @ prob : https://www.acmicpc.net/problem/2750
 */

import java.util.*;

public class BJ_2750_수정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numbers = new int[n];

        for(int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);
        for(int i : numbers) {
            System.out.println(i);
        }

        sc.close();
    }
}