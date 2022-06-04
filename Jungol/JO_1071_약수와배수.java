/**
 * JO 1071 약수와 배수
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=351&sca=2030
 * @ level : 
 */

import java.util.Scanner;

public class JO_1071_약수와배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int M = sc.nextInt();

        int divisorSum = 0, multipleSum = 0;
        for (int i = 0; i < N; i++) {
            if (M % nums[i] == 0) {
                divisorSum += nums[i];
            }
            if (nums[i] % M == 0) {
                multipleSum += nums[i];
            }
        }

        System.out.println(divisorSum);
        System.out.println(multipleSum);

        sc.close();
    }
}
