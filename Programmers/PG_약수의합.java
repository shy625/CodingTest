/**
 * PG 약수의 합
 * @ prob : https://school.programmers.co.kr/learn/courses/30/lessons/12928
 * @ level : 1
 */

class Solution {
    public int solution(int n) {
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    sum += i;
                } else {
                    sum += i + n / i;
                }
            }
        }
        return sum;
    }
}