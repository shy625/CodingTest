/**
 * BJ 1931 회의실 배정
 * @ prob : https://www.acmicpc.net/problem/1931
 * @ level : S2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1931_회의실배정 {

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        
        Meeting[] meetings = new Meeting[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings);

        int count = 0;
        int prevEnd = 0;
        for(int i = 0; i < N; i++) {
            if(meetings[i].start >= prevEnd) {
                count++;
                prevEnd = meetings[i].end;
            }
        }
        System.out.println(count);

        br.close();
    }
}

// 풀이 1
// 정렬 후 그리디
// 종료 시간이 빠른 순 -> 같다면 시작 시간이 빠른 순
// 종료 시간이 빠른 것을 먼저 선택해야 이후에 다른 회의들이 올 수 있는 더 많은 시간, 가능성을 확보
// 이전 종료 시간과 범위가 겹치지 않으면서 종료 시간이 가장 빠른 것을 차례대로 선택

// 다른 풀이 2
// PriorityQueue를 이용해서 정렬
// https://www.acmicpc.net/source/5467743