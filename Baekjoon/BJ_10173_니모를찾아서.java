/**
 * @ BJ 10173 니모를 찾아서
 * @ prob : https://www.acmicpc.net/problem/10173
 */

import java.util.Scanner;

public class BJ_10173_니모를찾아서 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        final String KEYWORD = "nemo";

        String input = "";
        while(!(input = sc.nextLine()).equals("EOI")) {
            input = input.toLowerCase();
            if(input.contains(KEYWORD)) {
                sb.append("Found\n");   // FOUND가 아니라 Found,,,
            } else {
                sb.append("Missing\n");
            }
        }
        System.out.println(sb.toString());

        sc.close();
    }
}
