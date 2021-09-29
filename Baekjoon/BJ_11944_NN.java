/**
 * @ BJ 11944 NN
 * @ prob : https://www.acmicpc.net/problem/11944
 */

import java.util.Scanner;

public class BJ_11944_NN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Integer.parseInt(n); i++) {
            if(sb.length() >= m) {
                sb.delete(m, sb.length());
                break;
            }
            sb.append(n);
        }
        System.out.println(sb.toString());

        sc.close();
    }
}

// 다른 풀이 1
// delete 대신에 substring() 이용

// for(int i = 0; i < (m = Math.min(m, n.length() * Integer.parseInt(n))); i++) {
//     sb.append(n);
// }
// System.out.println(sb.substring(0, m));