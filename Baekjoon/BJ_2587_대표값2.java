/**
 * @ BJ 2587 대표값2
 * @ prob : https://www.acmicpc.net/problem/2587
 */

import java.util.*;

public class BJ_2587_대표값2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[5];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        
        int sum = 0;
        for(int i : numbers) {
            sum += i;
        }
        System.out.println(sum / 5.0);

        Arrays.sort(numbers);
        System.out.println(numbers[2]);

        sc.close();
    }
}