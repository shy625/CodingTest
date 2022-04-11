/**
 * BJ 11723 집합
 * @ prob : https://www.acmicpc.net/problem/11723
 * @ level : S5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        // boolean[] setArr = new boolean[21];
        int bitSet = 0;     // 1~20번째 자리 사용, 0번째 자리 사용 X
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String comm = st.nextToken();
            int value = 0;
            switch(comm) {
                case "add" :
                    value = Integer.parseInt(st.nextToken());
                    bitSet = add(bitSet, value);
                    break;
                case "remove" :
                    value = Integer.parseInt(st.nextToken());
                    bitSet = remove(bitSet, value);
                    break;
                case "check" :
                    value = Integer.parseInt(st.nextToken());
                    sb.append(check(bitSet, value)).append(System.lineSeparator());
                    break;
                case "toggle" :
                    value = Integer.parseInt(st.nextToken());
                    bitSet = toggle(bitSet, value);
                    break;
                case "all" :
                    bitSet = all();
                    break;
                case "empty" :
                    bitSet = empty();
                    break;
            }
        }
        System.out.println(sb.toString());

        br.close();
    }

    private static int add(int bitSet, int value) {
        return bitSet | 1 << value;
    }

    private static int remove(int bitSet, int value) {
       return bitSet & ~(1 << value);
    }

    private static int check(int bitSet, int value) {
        return (bitSet & 1 << value) == 0 ? 0 : 1;
    }

    private static int toggle(int bitSet, int value) {
        return bitSet ^ 1 << value;     // XOR 연산 사용
        // if(check(bitSet, value) == 1) {
        //     return remove(bitSet, value);
        // } else {
        //     return add(bitSet, value);
        // }
    }

    private static int all() {
        return (1 << 21) - 1;
    }

    private static int empty() {
        return 0;
    }
}

// 풀이 1
// 배열 사용 -> 시간초과
// https://www.acmicpc.net/source/41841117

// 풀이 2
// 비트마스킹 사용
// https://www.acmicpc.net/source/41870370