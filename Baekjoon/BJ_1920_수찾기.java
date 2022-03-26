/**
 * BJ 1920 수 찾기
 * @ prob : https://www.acmicpc.net/problem/1920
 * @ level : S4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class BJ_1920_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] nArr = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] mArr = br.readLine().split(" ");

        Arrays.sort(nArr);
        for(int i = 0; i < M; i++) {
            sb.append(Arrays.binarySearch(nArr, mArr[i]) >= 0 ? 1 : 0).append(System.lineSeparator());
        }
        
        System.out.println(sb.toString());


        br.close();
    }
}

// 풀이 1
// binarySearch() 를 이용해 배열에 값 포함 여부 확인

// 풀이 2
// list.contains() 를 이용해 배열에 값 포함 여부 확인

// List<String> nList = Arrays.asList(nArr);
// for(int i = 0; i < M; i++) {
//     sb.append(nList.contains(mArr[i]) ? 1 : 0).append(System.lineSeparator());
// }

// 다른 풀이 1
// 배열의 값들을 Set에 넣고 contains() 을 사용해 값 포함 여부 확인
// https://www.acmicpc.net/source/37825234