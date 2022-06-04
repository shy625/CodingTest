/**
 * JO 2809 약수
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=450&sca=2030
 * @ level : 
 */

import java.util.Scanner;
import java.util.Arrays;

public class JO_2809_약수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        int sqrt = (int) Math.sqrt(N);
        int[] divisors = new int[sqrt * 2];
        int count = 0;
        for (int i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                divisors[count++] = i;
                if (i * i != N) {
                    divisors[count++] = N / i;
                }
            }
        }

        Arrays.sort(divisors);

        for (int div : divisors) {
            if (div != 0) {
                sb.append(div + " ");
            }
        }
        System.out.println(sb.toString());

        sc.close();
    }
}
