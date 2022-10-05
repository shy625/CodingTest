/**
 * PG 자릿수 더하기
 * @ prob : https://school.programmers.co.kr/learn/courses/30/lessons/12931
 * @ level : 1
 */

class Solution {
    public int solution(int n) {
        int radixSum = 0;
        while (n > 0) {
            radixSum += n % 10;
            n /= 10;
        }
        return radixSum;
    }
}