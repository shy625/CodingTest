/**
 * BJ 9019 DSLR
 * @ prob : https://www.acmicpc.net/problem/9019
 * @ level : G5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9019_DSLR {
    
    static class Node {
        int n;
        String cmdSeq;

        Node(int n, String cmdSeq) {
            this.n = n;
            this.cmdSeq = cmdSeq;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(bfs(a, b)).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }

    private static int cmdD(int n) {
        return 2 * n % 10000;
    }

    private static int cmdS(int n) {
        return n == 0 ? 9999 : n - 1;
    }

    private static int cmdL(int n) {
        int tmp = n % 1000;
        tmp *= 10;
        tmp += n / 1000;
        return tmp;
    }

    private static int cmdR(int n) {
        int tmp = n % 10;
        tmp *= 1000;
        tmp += n / 10;
        return tmp;
    }

    private static String bfs(int a, int b) {
        String result = "";
        Queue<Node> q = new LinkedList<>();
        boolean[] isVisited = new boolean[10000];

        q.offer(new Node(a, ""));
        isVisited[a] = true;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.n == b) {
                result = cur.cmdSeq;
                break;
            }
            for(int i = 0; i < 4; i++) {
                int nextN = 0;
                StringBuilder nextCmdSeq = new StringBuilder(cur.cmdSeq);
                if(i == 0) {
                    nextN = cmdD(cur.n);
                    nextCmdSeq.append("D");
                } else if(i == 1) {
                    nextN = cmdS(cur.n);
                    nextCmdSeq.append("S");
                } else if(i == 2) {
                    nextN = cmdL(cur.n);
                    nextCmdSeq.append("L");
                } else if(i == 3) {
                    nextN = cmdR(cur.n);
                    nextCmdSeq.append("R");
                }
                if(!isVisited[nextN]) {
                    isVisited[nextN] = true;
                    q.offer(new Node(nextN, nextCmdSeq.toString()));
                }
            }
        }
        return result;
    }
}

// 풀이 1
// 주어진 숫자에 대해 D, S, L, R을 수행하며 BFS로 이동
// 목표 숫자가 되면 BFS 종료
// 메모리, 시간 개선 필요 - 308156kb / 10096ms
// https://www.acmicpc.net/source/42774463

// 풀이 2
// 풀이 1에서 char 배열을 바탕으로 구현했던 L, R을 int 값에 /, % 을 이용해 구현하는 것으로 변경
// 속도 개선 - 8248ms

// 다른 풀이 1
// 수행한 명령어를 저장하기 위해 따로 클래스를 만들지 않고
// 현재 값을 자식, 이전 값을 부모로 하여 자신의 이전 값을 저장하는 int 배열 생성,
// idx를 값으로 하여 해당 값(idx)에 어떤 명령어를 수행하여 왔는지를 저장하는 char 배열 생성
// a->b에 도착한 이후로 위 2개 배열을 거꾸로 거슬러 올라가며 수행한 명렁어 리스트를 구함
// https://www.acmicpc.net/source/36485686