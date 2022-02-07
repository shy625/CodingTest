/**
 * SWEA 1218 괄호 짝짓기
 * @ prob : https://bit.ly/3GvEdIU
 * @ level : D4
 * @ Blog : 
 */

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String open = "([{<";
        String close = ")]}>";

        int T = 10;
        for(int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            String str = sc.next();
            int result = 1;

            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < n; i++) {
                char ch = str.charAt(i);
                if(open.contains(ch + "")) {    // 여는 괄호면 스택에 push
                    stack.push(ch);
                } else if(close.contains(ch + "")) {    // 닫는 괄호면 스택에서 pop
                    Character last = stack.pop();

                    // 짝이 맞는지 확인
                    if(ch == ')') {
                        if(!last.equals('(')) {
                            result = 0;
                            break;
                        }
                    } else if(ch == ']') {
                        if(!last.equals('[')) {
                            result = 0;
                            break;
                        }
                    } else if(ch == '}') {
                        if(!last.equals('{')) {
                            result = 0;
                            break;
                        }
                    } else if(ch == '>') {
                        if(!last.equals('<')) {
                            result = 0;
                            break;
                        }
                    }
                }
            }

            // 다 끝난 뒤 스택에 남은 괄호가 있는지 확인
            if(stack.size() > 0) {  
                result = 0;
            }

            System.out.println("#" + t + " " + result);
        }

        sc.close();
    }
}