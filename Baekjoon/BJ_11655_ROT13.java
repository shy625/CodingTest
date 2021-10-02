/**
 * @ BJ 11655 ROT13
 * @ prob : https://www.acmicpc.net/problem/11655
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ_11655_ROT13 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        // StringBuilder sb = new StringBuilder();
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if('A' <= ch && ch <= 'Z') {
                ch += 13;
                if(ch > 'Z') {
                    ch = (char)(ch - 'Z' + 'A' - 1);
                }
            } else if('a' <= ch && ch <= 'z') {
                ch += 13;
                if(ch > 'z') {
                    ch = (char)(ch - 'z' + 'a' - 1);
                }
            }
            System.out.print(ch);
            // sb.append(ch);
            // bw.writer(ch);
            // bw.append(ch);
        }
        // System.out.println(sb);
        // bw.flush();
        // bw.close();

        sc.close();
    }
}

// 다른 풀이 1
// https://www.acmicpc.net/source/16602904

// 다른 풀이 2
// https://www.acmicpc.net/source/6408478

// 다른 풀이 3
// https://www.acmicpc.net/source/4968723