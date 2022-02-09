/**
 * SWEA 1208 Flatten
 * @ prob : https://bit.ly/3oC9Mue
 * @ level : D3
 * @ blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SWEA_1208_Flatten {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1; t <= 10; t++) {
            int dumpCount = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");

            // 배열 정렬을 이용한 풀이
            int[] boxes = new int[100];
            for(int i = 0; i < 100; i++) {
                boxes[i] = Integer.parseInt(inputs[i]);
            }

            for(int i = 0; i < dumpCount; i++) {
                Arrays.sort(boxes);     // 배열 정렬
                int min = boxes[0];
                int max = boxes[99];
                if(max - min <= 1) {
                    break;
                } else {
                    boxes[0] = min + 1;
                    boxes[99] = max - 1;
                }
            }
            Arrays.sort(boxes);

            System.out.println("#" + t + " " + (boxes[99] - boxes[0]));

            // // 우선순위 큐를 2개 이용한 풀이
            // PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder()); // max 값 관리
            // PriorityQueue<Integer> minPQ = new PriorityQueue<>();   // min 값 관리

            // for(int i = 0; i < 100; i++) {
            //     int box = Integer.parseInt(inputs[i]);
            //     maxPQ.offer(box);
            //     minPQ.offer(box);
            // }

            // for(int i = 0; i < dumpCount; i++) {
            //     int max = maxPQ.poll();
            //     int min = minPQ.poll();
            //     if(max - min <= 1) {
            //         break;
            //     } else {
            //         maxPQ.offer(max - 1);
            //         minPQ.offer(min + 1);
            //     }
            // }

            // System.out.println("#" + t + " " + (maxPQ.poll() - minPQ.poll()));
        }

        br.close();
    }
}

// 다른 풀이 1
// 박스의 높이를 index로 하여 해당 index(높이)의 박스 개수를 가지는 배열 생성 -> max, min 값 찾는데 활용
// https://swexpertacademy.com/main/code/problem/problemSolverCodeDetail.do