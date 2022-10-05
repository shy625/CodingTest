/**
 * PG 정수 제곱근 판별
 * @ prob : https://school.programmers.co.kr/learn/courses/30/lessons/12934
 * @ level : 1
 */

class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        long x = (long) sqrt;
        if (sqrt != x) {
            return -1;
        } else {
            return (x + 1) * (x + 1);
        }
    }
}