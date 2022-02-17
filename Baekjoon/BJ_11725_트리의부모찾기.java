/**
 * BJ 11725 트리의 부모 찾기
 * @ prob : https://www.acmicpc.net/problem/11725
 * @ level : S2
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_11725_트리의부모찾기 {

    static int N;
    static Node[] tree;
    // static boolean[] isVisited;
    static int[] parents;   // 노드의 부모 정보

    // 트리의 노드
    static class Node {
        int num;
        Node next;

        Node(int num, Node next) {
            this.num = num;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        // isVisited = new boolean[N+1];
        parents = new int[N+1];

        tree = new Node[N+1];
        for(int i = 0; i < N-1; i++) {
            String[] inputs = br.readLine().split(" ");
            int num1 = Integer.parseInt(inputs[0]);
            int num2 = Integer.parseInt(inputs[1]);
            addNode(num1, num2);
            addNode(num2, num1);
        }

        // isVisited[1] = true;
        // dfs(0, 1);
        // findParent();
        bfs();

        // 2번 노드부터 부모 출력
        for(int i = 2; i < N+1; i++) {
            sb.append(parents[i]).append(System.lineSeparator());
        }
        System.out.print(sb.toString());

        br.close();
    }
    
    // 인접 리스트에 노드 추가
    private static void addNode(int num1, int num2) {
        Node node = new Node(num2, null);
        node.next = tree[num1];
        tree[num1] = node;
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        parents[1] = -1;    // 1번이 루트
        q.offer(new Node(1, null));     // 1번 노드부터 시작
        while(!q.isEmpty()) {
            int curNum = q.poll().num;
            Node node = tree[curNum];       // poll()해서 나온 노드에 연결된 노드들 탐색
            // parents[node.num] = parentNum;
            while(node != null) {   
                // Node next = node.next;
                if(parents[node.num] == 0) {    // 부모가 아직 설정되지 않은 경우
                    parents[node.num] = curNum;     // 현재 노드를 부모로 설정
                    q.offer(node);      // 큐에 넣음
                }
                node = node.next;   // 다음 노드 탐색
            }
        }
    }

    // 반복문
    // private static void findParent() {
    //     isVisited[1] = true;
    //     for(int i = 1; i < N+1; i++) {
    //         Node cur = tree[i];
    //         while(cur != null) {
    //             if(!isVisited[cur.num]) {
    //                 parents[cur.num] = i;
    //                 isVisited[cur.num] = true;
    //             }
    //             cur = cur.next;
    //         }
    //     }
    // }

    // DFS
    // private static void dfs(int prevNum, int curNum) {
    //     parents[curNum] = prevNum;
    //     Node cur = tree[curNum];
    //     while(cur != null) {
    //         // Node next = cur.next;
    //         if(!isVisited[cur.num]) {
    //             isVisited[cur.num] = true;
    //             dfs(curNum, next.num);
    //         }
    //         cur = next;
    //     }
    // }
}

// 풀이 1
// 인접 행렬 -> 메모리 초과

// 풀이 2
// DFS 시도 -> 실패

// 풀이 3
// 반복문 시도 -> 실패

// 풀이 4
// BFS 시도 -> 성공