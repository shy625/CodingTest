/**
 * JO 1430 숫자의 개수
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=706&sca=2030
 * @ level : 
 */

import java.util.Scanner;

public class JO_1430_숫자의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int mul = A * B * C;

        int[] digitCount = new int[10];
        while (mul > 0) {
            digitCount[mul % 10]++;
            mul /= 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(digitCount[i]);
        }

        sc.close();
    }
}
