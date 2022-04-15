/**
 * BJ 18870 좌표 압축
 * @ prob : https://www.acmicpc.net/problem/18870
 * @ level : S2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_18870_좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        Integer[] setArr = set.toArray(new Integer[set.size()]);
        Arrays.sort(setArr);

        for(int i = 0; i < N; i++) {
            int count = Arrays.binarySearch(setArr, arr[i]);
            sb.append(count + " ");
        }

        System.out.println(sb.toString());
        
        br.close();
    }
}

// 풀이 1 - 시간초과
// HashSet을 이용해 중복을 제거한 결과를 PriorityQueue에 넣고,
// 자신과 같은 값이 나올 때까지 poll()하면서 자신보다 작은 수의 개수를 구함
// N 최대 100만, O(N^2*logN)의 시간복잡도 -> 시간초과
// https://www.acmicpc.net/source/42036116

// 풀이 2 - 시간초과
// HashSet을 이용해 중복 제거한 결과를 List에 넣고 정렬
// List에 대해 indexOf()를 이용해 자신보다 작은 수의 개수를 구함
// 정렬된 list에서의 index = 자신보다 작은 수의 개수
// N 최대 100만, O(N^2)의 시간복잡도 -> 시간초과
// https://www.acmicpc.net/source/42036285

// 풀이 3
// 풀이 2에서 List 대신 Array를 사용하여 indexOf() 대신 binarySearch()를 이용해 index 구함
// N 최대 100만, O(N*logN)의 시간복잡도 -> 성공
// 위 코드

// 다른 풀이 1
// 정렬과 HashMap을 이용
// 정렬된 결과의 앞에서부터 HashMap에 없다면 넣음
// HashMap에 넣을 때 idx 값을 1씩 증가시키면서 value에 넣음 <- 자신보다 작은 수의 개수
// HashMap의 get(), put(), containsKey()는 O(1)의 시간복잡도를 가지므로 자신보다 작은 수의 개수를 구하는 부분의 시간복잡도는 O(N)
// 따라서 정렬 시의 시간복잡도가 가장 크므로 전체 코드는 O(N*logN)의 시간복잡도를 가짐
// https://www.acmicpc.net/source/28174005

// 다른 풀이 2
// https://www.acmicpc.net/source/28540081