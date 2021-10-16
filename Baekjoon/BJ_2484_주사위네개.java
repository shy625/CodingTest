/**
 * @ BJ 2484 주사위 네개
 * @ prob : https://www.acmicpc.net/problem/2484
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_2484_주사위네개 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int[] arr = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
            int result = calculateReward(arr);
        }

        sc.close();
    }
    
    static int calculateReward(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int result = 0;
        switch(set.size()) {
            case 1 :
                result = 50000;
                break;
        }
        return result;
    }
}