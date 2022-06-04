/**
 * JO 1002 최대공약수, 최소공배수
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=281&sca=2030
 * @ level : 
 */

import java.util.Scanner;

public class JO_1002_최대공약수최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int gcd = nums[0], lcm = nums[0];
        for (int i = 1; i < N; i++) {
            gcd = gcd(nums[i], gcd);
            lcm = lcm * nums[i] / gcd(lcm, nums[i]);
        }


        System.out.println(gcd + " " + lcm);

        sc.close();
    }
    
    private static int gcd(int a, int b) {
        int r = 0;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
