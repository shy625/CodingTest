/**
 * 이코테 3-4 1이 될 때까지
 * @ prob : 
 * @ level : 
 */

import java.io.*;

public class 이코테_3_4_1이될때까지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        // 방법 1. K로 나누기 또는 1 빼기를 단순 반복 - 입력이 큰 경우 1씩 일일이 빼는 것은 비효율적
        // int count = 0;
        // while (N != 1) {
        //     if (N % K == 0) {
        //         N /= K;
        //     } else {
        //         N--;
        //     }
        //     count++;
        // }

        // 방법 2. 1을 일일이 빼지 않고 K의 배수가 되도록 한번에 빼기
        int count = 0;
        while (N != 1) {
            if (N % K == 0) {   // N이 K로 나누어 떨어지면 K로 나누기
                N /= K;
                count++;
            } else {    // N이 K로 나누어 떨어지지 않는 경우
                if (N > K) {    // N이 K보다 크면 다음 K의 배수로 바로 빼기
                    int target = (N / K) * K;
                    count += N - target;
                    N = target;
                } else {    // N이 K보다 작으면 1씩 빼기
                    N--;
                    count++;
                }
            }
        }

        System.out.println(count);

        br.close();
    }
}
