/**
 * @ BJ 3040 백설 공주와 일곱 난쟁이
 * @ prob : https://www.acmicpc.net/problem/3040
 */

import java.util.Scanner;

public class BJ_3040_백설공주와일곱난쟁이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[9];
        int sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
            sum += numbers[i];
        }

        outer :
        for(int i = 0; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                if((sum - numbers[i] - numbers[j]) == 100) {
                    for(int k = 0; k < numbers.length; k++) {
                        if(k == i || k == j) {
                            continue;
                        }
                        System.out.println(numbers[k]);
                    }
                    break outer;
                }
            }
        }

        sc.close();
    }
}