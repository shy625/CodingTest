/**
 * BJ 4949 균형잡힌 세상
 * @ prob : https://www.acmicpc.net/problem/4949
 * @ level : S4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String line = br.readLine();
            if(line.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            for(int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if(ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if(ch == ')') {
                    if(stack.isEmpty() || stack.pop() != '(') {
                        isBalanced = false;
                        break;
                    }
                } else if(ch == ']') {
                    if(stack.isEmpty() || stack.pop() != '[') {
                        isBalanced = false;
                        break;
                    }
                }
            }
            if(stack.size() > 0) {
                isBalanced = false;
            }

            if(isBalanced) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }
}
