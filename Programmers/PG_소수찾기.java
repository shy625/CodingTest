/**
 * PG 소수 찾기
 * @ prob : https://programmers.co.kr/learn/courses/30/lessons/42839
 * @ level : 2
 */

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    
    static boolean[] isPrime;
    static Set<Integer> primeSet;
    
    public int solution(String numbers) {
        int[] cards = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            cards[i] = numbers.charAt(i) - '0';
        }
        
        Arrays.sort(cards);
        
        String maxNum = "";
        for (int i = cards.length - 1; i >= 0; i--) {
            maxNum += cards[i];
        }
        
        isPrime = new boolean[Integer.parseInt(maxNum) + 1];
        checkPrime(isPrime);
        
        primeSet = new HashSet<>();
        for (int i = 1; i <= cards.length; i++) {
            perm(i, "", cards, new boolean[cards.length]);
        }
        
        return primeSet.size();
        
    }
    
    private void checkPrime(boolean[] isPrime) {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        int n = isPrime.length - 1;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = 2; i * j <= n; j++) {
                isPrime[i * j] = false;
            }
        }
    }
    
    private void perm(int n, String numStr, int[] cards, boolean[] isChecked) {
        if (numStr.length() == n) {
            if (numStr.charAt(0) != '0') { 
                int num = Integer.parseInt(numStr);
                if (isPrime[num]) {
                    primeSet.add(num);
                }
            }
            return;
        }
        for (int i = 0; i < isChecked.length; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                perm(n, numStr + cards[i], cards, isChecked);
                isChecked[i] = false;
            }
        }
    }
    
}

// 풀이 1
// 주어진 수로 만들 수 있는 가장 큰 수를 구함
// 해당 수까지의 모든 수에 대해서 에라토스테네스의 체 알고리즘을 이용하여 소수 여부 배열에 저장
// 순열을 이용해 주어진 숫자로 만들 수 있는 모든 수를 생성하여 그 중 소수인 수를 Set에 저장
// Set의 크기 반환