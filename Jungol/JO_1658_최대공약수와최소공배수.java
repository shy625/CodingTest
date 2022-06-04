/**
 * JO 1658 최대공약수와 최소공배수
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=931&sca=2030
 * @ level : 
 */

import java.util.Scanner;

public class JO_1658_최대공약수와최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = gcd(a, b);
        int lcm = a * b / gcd;

        System.out.println(gcd);
        System.out.println(lcm);

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
