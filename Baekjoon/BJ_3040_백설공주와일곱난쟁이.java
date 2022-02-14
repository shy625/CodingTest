/**
 * @ BJ 3040 백설 공주와 일곱 난쟁이
 * @ prob : https://www.acmicpc.net/problem/3040
 * @ level : B2
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3040_백설공주와일곱난쟁이 {

    static int[] nums = new int[9];
    static boolean[] checked = new boolean[9];
    static int sum;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }

        combi(0, 0, 0, checked);

        br.close();
    }

    // 조합 함수
    private static void combi(int count, int start, int total, boolean[] checked) {
        if(count == 2 && sum - total == 100) {
            for(int i = 0; i < checked.length; i++) {
                if(!checked[i]) {
                    System.out.println(nums[i]);
                }
            }
        }
        for(int i = start; i < nums.length; i++) {
            checked[i] = true;
            combi(count + 1, i + 1, total + nums[i], checked);
            checked[i] = false;
        }
    }
}

// 풀이 1
// 반복문 이용

// import java.util.Scanner;
//
// public class BJ_3040_백설공주와일곱난쟁이 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//
//         int[] numbers = new int[9];
//         int sum = 0;
//         for(int i = 0; i < numbers.length; i++) {
//             numbers[i] = sc.nextInt();
//             sum += numbers[i];
//         }
//
//         outer :
//         for(int i = 0; i < numbers.length-1; i++) {
//             for(int j = i+1; j < numbers.length; j++) {
//                 if((sum - numbers[i] - numbers[j]) == 100) {    // 2개를 제외했을 때 합이 100이 되는 경우
//                     for(int k = 0; k < numbers.length; k++) {
//                         if(k == i || k == j) {
//                             continue;
//                         }
//                         System.out.println(numbers[k]);
//                     }
//                     break outer;
//                 }
//             }
//         }
//
//         sc.close();
//     }
// }