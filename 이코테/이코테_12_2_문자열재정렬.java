/**
 * 이코테 12-2 문자열 재정렬
 * @ prob : 
 * @ level : 
 */

import java.util.*;

public class 이코테_12_2_문자열재정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] S = sc.nextLine().toCharArray();

        Arrays.sort(S);

        int sum = 0;
        String subS = "";
        for (int i = 0; i < S.length; i++) {
            if ('0' <= S[i] && S[i] <= '9') {
                sum += S[i] - '0';
            } else {
                subS = String.valueOf(S).substring(i);
                break;
            }
        }

        System.out.println(sum != 0 ? subS + sum : subS);

        sc.close();
    }
}
