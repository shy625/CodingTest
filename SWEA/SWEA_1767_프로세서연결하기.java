/**
 * SWEA 1767 프로세서 연결하기
 * @ prob : https://bit.ly/3jq2sz8
 * @ level : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기 {

    static int[] dr = {0, -1, 0, 1, 0};     // x, 상, 우, 하, 좌
    static int[] dc = {0, 0, 1, 0, -1};     // x, 상, 우, 하, 좌
    static int N;
    static int[][] processor;
    static List<int[]> coreList;    // 가장자리 core를 제외한 core 리스트
    static int maxCore, minLine;    // 최대 연결 core 수, 그때의 최소 라인 길이 합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            processor = new int[N][N];
            coreList = new ArrayList<>();

            for(int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine().trim(), " ");
                for(int c = 0; c < N; c++) {
                    processor[r][c] = Integer.parseInt(st.nextToken());
                    if(processor[r][c] == 1) {
                        if(r != 0 && r != N-1 && c != 0 && c != N-1) {      // 가장자리 core 제외
                            coreList.add(new int[] {r, c});
                        }
                    }
                }
            }

            maxCore = 0;
            minLine = Integer.MAX_VALUE;

            subset(0, 0, 0);

            sb.append("#" + t + " " + minLine).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }

    private static void subset(int index, int count, int lineSum) {
        if(index == coreList.size()) {
            if(maxCore < count) {
                maxCore = count;
                minLine = lineSum;
            } else if(maxCore == count) {
                minLine = Math.min(minLine, lineSum);
            }
            // System.out.println(count + " " + lineSum);
            // print();
            return;
        }

        int[] pos = coreList.get(index);

        // 현재 선택된 core에 대해서 x, 상, 우, 하, 좌 시도 후 다음 core에 대해 함수 호출
        for(int i = 0; i < 5; i++) {
            if(i == 0) {    // 현재 core를 연결하지 않는 경우
                subset(index + 1, count, lineSum);
            } else {    // 현재 core를 i 방향으로 연결하는 경우
                if(available(pos, i)) {     // 해당 방향으로 연결 가능 여부 체크
                    int line = setLine(pos, i);     // 연결
                    subset(index + 1, count + 1, lineSum + line);
                    unsetLine(pos, i);      // 연결 해제
                }
            }
        }
    }

    private static void unsetLine(int[] pos, int dir) {
        int r = pos[0] + dr[dir];
        int c = pos[1] + dc[dir];
        while(isInOfBound(r, c)) {
            processor[r][c] = 0;
            r += dr[dir];
            c += dc[dir];
        }
    }

    private static int setLine(int[] pos, int dir) {
        int r = pos[0] + dr[dir];
        int c = pos[1] + dc[dir];
        int count = 0;
        while(isInOfBound(r, c)) {
            processor[r][c] = 2;
            count++;
            r += dr[dir];
            c += dc[dir];
        }
        return count;
    }

    private static boolean available(int[] pos, int dir) {
        int r = pos[0] + dr[dir];
        int c = pos[1] + dc[dir];
        while(isInOfBound(r, c)) {
            if(processor[r][c] != 0) {
                return false;
            }
            r += dr[dir];
            c += dc[dir];
        }
        return true;
    }

    private static boolean isInOfBound(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    // private static void print() {
    //     for(int i = 0 ; i < N; i++) {
    //         for(int j = 0; j < N; j++) {
    //             System.out.print(processor[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // }
}

// 풀이 1
// 부분집합 사용
// 전체 core 중 가장자리 core를 제외한 나머지 core에 대해서만 아래 내용 진행
// N개 core 중 0개에 전선 연결 시도하는 경우, 1개에 연결 시도하는 경우, 2개에 연결 시도하는 경우, ... , N개에 연결 시도하는 경우에 대해 계산
// 즉, nC0, nC1, nC2, ... , nCn -> 부분집합
// 단, 기존 부분집합이 뽑거나 안뽑거나인 반면 이 문제의 경우 연결하지 않거나, 위로 연결하거나, 오른쪽, 아래, 왼쪽으로 연결하는 총 5가지 경우가 있으므로 5^n 가지 경우의 수
// core는 최대 12개까지 있을 수 있으므로 5^12 = 약 2억이고 50개 테스트케이스에 4초니까 약 100억번의 연산으로 시간초과가 발생할 수 있다.
// 그러나 실제로는 한 core에 대해서 전선을 연결할 때마다 이후 core에서 확인해야할 경우의 수가 제한되므로 제한시간 내에 통과할 수 있다.