/**
 * PG 타겟 넘버
 * @ prob : https://programmers.co.kr/learn/courses/30/lessons/43165
 * @ level : 2
 */

class Solution {    
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int calResult, int idx) {
        if (idx == numbers.length) {
            if (calResult == target) {
                return 1;
            }
            return 0;
        }
        int count1 = dfs(numbers, target, calResult + numbers[idx], idx + 1);
        int count2 = dfs(numbers, target, calResult - numbers[idx], idx + 1);
        return count1 + count2;
    }
}

// 풀이 1
// DFS 사용
// 주어진 숫자들의 순서는 그대로 두고 빼거나 더해서 타겟 숫자 만들기
// 재귀 진행 시 현재 숫자를 더하는 경우, 빼는 경우 2가지를 진행