/**
 * BJ 5430 AC
 * @ prob : https://www.acmicpc.net/problem/5430
 * @ level : G5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // 입력
            String funcList = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            st = new StringTokenizer(arrStr.substring(1, arrStr.length() - 1), ",");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 처리
            int flag = 1; // 1 : 왼->오, -1 : 오->왼, 0 : 에러
            int head = 0, tail = N - 1;
            for (int i = 0; i < funcList.length(); i++) {
                char func = funcList.charAt(i);
                if (func == 'R') {
                    flag = -flag;
                } else if (func == 'D') {
                    if (head > tail) { // 배열의 크기가 0인 경우
                        flag = 0;
                        break;
                    }
                    if (flag > 0) { // 앞에서 제거
                        head++;
                    } else if (flag < 0) { // 뒤에서 제거
                        tail--;
                    }
                }
            }

            // 출력
            if (flag == 0) {
                sb.append("error");
            } else {
                sb.append("[");
                if (head <= tail) { // 배열의 크기가 1이상인 경우 
                    if (flag > 0) { // 왼->오 로 출력
                        for (int i = head; i <= tail; i++) {
                            sb.append(arr[i]).append(",");
                        }
                    } else { // 오->왼 으로 출력
                        for (int i = tail; i >= head; i--) {
                            sb.append(arr[i]).append(",");
                        }
                    }
                    sb.setLength(sb.length() - 1);
                }
                sb.append("]");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1 - 시간초과
// 결과 문자열 만들 때 Arrays.toString().replaceAll(" ", "") 을 이용
// https://www.acmicpc.net/source/42866324

// 풀이 2 - fail
// 출력 시 배열의 크기가 0인 경우를 고려 X
// "[" 로 출력됨

// 풀이 3
// 주어진 입력을 ArrayList로 변환하여 처리
// R이 들어올 때마다 실제로 뒤집지 않고 flag만 변경
// D가 들어오면 flag에 따라 List의 앞 또는 뒤에서 원소 1개 제거
// 출력 시 flag 값이 -1이면 List를 한번 뒤집고, StringBuilder를 이용해서 결과를 만들어 출력
// https://www.acmicpc.net/source/42866410

// 풀이 4
// 주어진 입력을 배열로 처리
// R에 대해서는 flag를 둬서 처리
// D에 대해서 실제로 앞 또는 뒤의 원소를 제거하는 것이 아니라 head, tail의 index 값만 변경
// 출력 시 head~tail 범위의 원소를 그대로 또는 뒤집어서 StringBuilder로 결과를 만들어 출력
// https://www.acmicpc.net/source/31327519