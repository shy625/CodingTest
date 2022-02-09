/**
 * IM example 기지국
 * @ prob : 
 * @ level : 
 * @ blog : 
 */

/**
 * [문제]
 * SS 텔레콤에서 현재 기지국의 위치와 집들이 표시된 지도를 2차원 nxn 배열로 변환하여,
 * 기지국에 커버 되지 않는 집의 수를 찾고자 한다.
 * 기지국은 [그림1]과 같이 세가지 종류가 있다.
 * 각각의 기지국은 기지국이 위치한 셀에서 동서남북으로 각 1개, 2개, 3개의 셀을 커버하며, 하나의 집은 1개의 셀에 있다.
 * 
 * 주어진 2차원 배열 지도에 위치한 기지국으로 커버되지 않는 집의 수를 찾는 프로그램을 작성하시오.
 */

import java.util.Scanner;

public class IM_example_기지국 {

    static int N;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            map = new char[N][N];

            // 지도 초기화
            for(int i = 0; i < N; i++) {
                map[i] = sc.next().toCharArray();
            }

            int r = 0, c = 0;
            // 지도 반복
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    char cur = map[i][j];
                    // 현재 위치가 기지국이면
                    if(cur != 'X' && cur != 'H') {  
                        int length = cur - 'A';     // 기지국 종류에 따른 범위 설정
                        // 4방 탐색
                        for(int k = 0; k < 4; k++) {
                            r = i;
                            c = j;
                            // 각 방향으로 범위만큼 탐색
                            for(int l = 0; l <= length; l++) {  
                                r += dr[k];
                                c += dc[k];
                                // 배열 밖으로 나가면 break
                                if(r < 0 || N <= r || c < 0 || N <= c) {
                                    break;
                                }
                                // 기지국 범위 안에 집이 있으면 제외
                                if(map[r][c] == 'H') {
                                    map[r][c] = 'X';
                                }
                            }
                        }
                    }
                }
            }

            int count = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    // 기지국 범위 안에 있는 집을 제외하고 남는 집 개수 세기
                    if(map[i][j] == 'H') {
                        count++;
                    }
                }
            }

            System.out.println("#" + t + " " + count);
        }

        sc.close();
    }
}

/*
[입력]
10
5
XXXXX
XHXXX
HXAHX
XHHXX
XBHHX
9
XXXXXXXXX
XXXHXXXXX
XXHAHXXHX
XXHHXXXXX
XXXXXXXXX
XXAHHXXXX
XXHXXHAHX
XXAHXXHXX
XXHXHXXXX
9
XXXXXXXXX
XXHHHXXXX
XXHAHXHXX
XXHHHXHXX
XXXHXXXXX
XXXBXXXXX
XXXXXXCHH
XXXXXXXXX
XXXHXXHXX
10
XXXXXXXXXX
XXXHXXXXXX
XHXAHXXXXX
XXXHXXHXXX
XXXHXXHXXX
XXBXXXHXXX
HXHHHHCHHH
XXHXXXHXXX
XXXXXXHXXX
XXHXXXHXXX
10
XXXXXXXXXX
XXXXHXXXXX
XXHAHAXXXX
XXXAHAXXXX
XXHBHHAXXX
XXHBACHXXX
BXXHBCXXXX
HAHCHHAXXX
XXXXXHXXXX
XXXXXXXXXX
9
XXXXHXXXX
XXXXXXXXX
XHXXHXXXX
XXXXXXXXX
XHXXHXXXX
XXXXHHXXH
XXXXXHXXX
XHXXXHXXX
XXXXXXXXX
9
HHHHHHHHH
HHHHHHHHH
HHHHHHHHH
HHHHHHHHH
HHHHHHHHH
HHHHHHHHH
HHHHHHHHH
HHHHHHHHH
HHHHHHHHH
10
XAXXXCXXXX
XBXCXAXXXX
XXXBACXXXX
XXXBBABXXX
XXXACXXXXX
XXXXXXAXXX
XCXXXXBXXX
XXAXCXCXXX
XXXXXXXXXX
XXXXXXXXXX
10
ABABCABCAC
BACABACBAC
ABCABCABAC
BACBAABCAB
ABBAABCABC
ABCBABCBAA
ABBBAABCCA
ABBCCABCAB
ABBCAACBBC
ABBCCAACBA
10
HHHHHHHHHH
ABCBABAABA
HHHHHHHHHH
ABCBABCCAB
HHHHHHHHHH
AABCAABBCA
HHHHHHHHHH
BCABBCBCAC
HHHHHHHHHH
CABBCAACCB


[출력]
#1 2
#2 4
#3 6
#4 4
#5 1
#6 11
#7 81
#8 0
#9 0
#10 0
*/