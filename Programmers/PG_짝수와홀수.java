/**
 * PG 짝수와 홀수
 * @ prob : https://school.programmers.co.kr/learn/courses/30/lessons/12937
 * @ level : 1
 */

class Solution {
    public String solution(int num) {
        return (num & 1) == 1 ? "Odd" : "Even";
    }
}