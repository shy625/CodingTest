/**
 * JO 1692 곱셈
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=965&sca=2030
 * @ level : 
 */

import java.util.Scanner;

public class JO_1692_곱셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int tmp = b;
        for (int i = 0; i < 3; i++) {
            int x = tmp % 10;
            tmp /= 10;
            System.out.println(a * x);
        }
        System.out.println(a * b);

        sc.close();
    }
}
