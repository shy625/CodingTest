/**
 * BJ 9012 괄호
 * @ prob : https://www.acmicpc.net/problem/9012
 * @ level : S4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String line = br.readLine();
            Stack<Character> stack = new Stack<>();

            boolean isVps = true;
            for(int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if(ch == '(') {
                    stack.push(ch);
                } else if(ch == ')') {
                    if(stack.isEmpty() || stack.pop() != '(') {
                        isVps = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) {
                isVps = false;
            }
            sb.append(isVps ? "YES" : "NO").append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }
}
