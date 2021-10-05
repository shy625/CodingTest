/**
 * @ BJ 11650 좌표 정렬하기
 * @ prob : https://www.acmicpc.net/problem/11650
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BJ_11650_좌표정렬하기 {
    public static void main(String[] args) {

        // inner class
        class Coordinate implements Comparable {
            int x;
            int y;

            public Coordinate(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int compareTo(Object o) {
                if(o instanceof Coordinate) {
                    Coordinate c = (Coordinate)o;
                    return x != c.x ? x - c.x : y - c.y;
                } else {
                    return 0;
                }
            }
        }

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Coordinate[] positions = new Coordinate[n];
        for(int i = 0; i < n; i++) {
            positions[i] = new Coordinate(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(positions);
        for (Coordinate c : positions) {
            System.out.println(c.x + " " + c.y);
        }

        sc.close();
    }
}

// class Coordinate implements Comparable {
//     int x;
//     int y;
//
//     public Coordinate(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }
//
//     @Override
//     public int compareTo(Object o) {
//         if(o instanceof Coordinate) {
//             Coordinate c = (Coordinate)o;
//             return x != c.x ? x - c.x : y - c.y;
//         } else {
//             return 0;
//         }
//     }
// }

// 다른 풀이 1
// Array나 List에 넣고 익명메소드를 정의하여 정렬
// List - https://www.acmicpc.net/source/16278149
// Array - https://www.acmicpc.net/source/18085875

// int[][] positions = new int[n][2];
// for(int i = 0; i < n; i++) {
//     positions[i][0] = sc.nextInt();
//     positions[i][1] = sc.nextInt();
// }
//
// // 익명메소드 - 기본
// // Arrays.sort(positions, new Comparator<int[]>(){
// //     @Override
// //     public int compare(int[] p1, int[] p2) {
// //         return p1[0] != p2[0] ? p1[0] - p2[0] : p1[1] - p2[1];
// //     }  
// // });
//
// // 익명메소드 - 람다식
// Arrays.sort(positions, (p1, p2) -> {
//     return p1[0] != p2[0] ? p1[0] - p2[0] : p1[1] - p2[1];
// });
// for (int[] position : positions) {
//     System.out.println(position[0] + " " + position[1]);
// }


// 다른 풀이 2
// 문제의 제약조건 (-100,000 ≤ xi, yi ≤ 100,000) 을 활용하여 x, y 좌표를 하나의 int 값으로 합쳐서 계산

// long[] positions = new long[n];
// for(int i = 0; i < n; i++) {
//     positions[i] = sc.nextInt() * 1000000L + sc.nextInt();
// }
// Arrays.sort(positions);
// for (long position : positions) {
//     long x = (long)Math.round((double)position / 1000000);
//     System.out.println(x + " " + (position - x * 1000000));
// }

// 다른 풀이 3
// 제약조건 이용 -> 비트 연산 이용
// https://www.acmicpc.net/source/15233726