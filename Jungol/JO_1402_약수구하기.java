/**
 * JO 1402 약수 구하기
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=678&sca=2030
 * @ level : 
 */

import java.util.Scanner;

public class JO_1402_약수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                K--;
                if (K == 0) {
                    result = i;
                    break;
                }
            }
        }

        System.out.println(result);

        sc.close();
    }
}
