/**
 * @ BJ 2752 세수정렬
 * @ prob : https://www.acmicpc.net/problem/2752
 */

import java.util.*;

public class BJ_2752_세수정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
        // int[] numbers = new int[3];
        // for(int i = 0; i < 3; i++) {
        //     numbers[i] = sc.nextInt();
        // }
        Arrays.sort(numbers);
        System.out.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);

        sc.close();
    }
}