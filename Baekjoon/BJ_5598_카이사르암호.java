/**
 * @ BJ 5598 카이사르 암호
 * @ prob : https://www.acmicpc.net/problem/5598
 */

import java.util.Scanner;

public class BJ_5598_카이사르암호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] code = sc.nextLine().toCharArray();
        for(int i = 0; i < code.length; i++) {
            code[i] = decode(code[i]);
        }
        System.out.println(code);

        sc.close();
    }

    static char decode(char input) {
        char output = (char)(input - 3);
        if(output < 'A') {
            output += 26;
        }
        return output;
    }
}