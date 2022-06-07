/**
 * PG 단어 변환
 * @ prob : https://programmers.co.kr/learn/courses/30/lessons/43163
 * @ level : 3
 */

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean hasTarget = false;
        
        // words 배열에 target 단어가 있는지 확인
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) {
                hasTarget = true;
                break;
            }
        }
        
        if (hasTarget) {    // words 배열에 target이 있을 때만 bfs 진행
            answer = bfs(begin, target, words);
        }
        
        return answer;
    }
    
    private int bfs(String begin, String target, String[] words) {
        Queue<int[]> q = new LinkedList<>();    // { 단어의 idx, 변환 횟수 }
        boolean[] isChecked = new boolean[words.length];
        int count = 0;
        
        q.offer(new int[] { -1, 0 });   // begin 단어는 words에 없으니 -1로 초기화
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            String curWord = cur[0] == -1 ? begin : words[cur[0]];
            if (curWord.equals(target)) {
                count = cur[1];
                break;
            }
            for (int i = 0; i < words.length; i++) {
                if (!isChecked[i] && isDiffOneChar(curWord, words[i])) {
                    isChecked[i] = true;
                    q.offer(new int[] { i, cur[1] + 1 });
                }
            }
        }
        
        return count;
    }
    
    private boolean isDiffOneChar(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                break;
            }
        }
        return diffCount == 1;
    }
}

// 풀이 1
// 최소 변환 횟수를 찾는 것이므로 BFS 사용
// { 단어의 idx, 변환 횟수 } 배열을 저장하는 Queue 사용
// 큐에서 원소를 뽑고, words 배열을 돌면서 아직 체크되지 않았고 현재 단어에서 변환할 수 있는 단어인지 확인
// 두 조건을 만족하는 경우 방문 처리 후 큐에 추가
// 큐에서 target과 동일한 단어가 나올 때까지 반복