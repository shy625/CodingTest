/**
 * @ SWEA 2063 중간값 찾기
 * @ prob : https://bit.ly/3qjHsy1
 * @ level : D1
 */

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2063_중간값찾기 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++) {
        	nums[i] = sc.nextInt();   
        }
		
        Arrays.sort(nums);
        
        System.out.println(nums[n/2]);

        sc.close();
    }
}