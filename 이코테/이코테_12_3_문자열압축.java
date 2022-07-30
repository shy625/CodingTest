/**
 * 이코테 12-3 문자열 압축
 * @ prob : https://school.programmers.co.kr/learn/courses/30/lessons/60057
 * @ level : 2
 */

import java.util.*;

class Solution {
    public int solution(String s) {
        int minLength = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            minLength = Math.min(minLength, compressString(s, i));
        }
        return minLength;
    }

    private int compressString(String str, int unit) {
        List<String> unitList = new ArrayList<>();
        for (int i = 0; i < str.length(); i += unit) {
            String subStr = "";
            if (i + unit < str.length()) {
                subStr = str.substring(i, i + unit);
            } else {
                subStr = str.substring(i);
            }
            unitList.add(subStr);
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < unitList.size() - 1; i++) {
            String cur = unitList.get(i);
            String next = unitList.get(i + 1);
            if (cur.equals(next)) {
                count++;
            } else {
                String compStr = cur;
                if (count > 1) {
                    compStr = count + compStr;
                } 
                sb.append(compStr);
                count = 1;
            }
        }
        if (count > 1) {
            sb.append(count);
        }
        sb.append(unitList.get(unitList.size() - 1));

        return sb.length();
    }
}

// 풀이 1
// 자르는 단위를 1 ~ 문자열 길이의 절반까지로 하여 압축해보며 그 중 최솟값 찾기
// 단위가 문자열의 절반 이상이 되면 압축한 길이는 원래 문자열의 길이와 동일하므로 진행할 필요 x
// 문자열 압축은 먼저 문자열을 주어진 단위로 나누어 리스트에 넣고
// 리스트에서 하나씩 빼면서 같은지 여부를 확인하여 압축 진행

// 다른 풀이 1
// 재귀를 이용해 압축 문자열을 구하기
// 재귀함수에 문자열, 자르는 단위, 반복해서 나온 횟수를 인자로 주고
// 잘린 나머지 뒤의 문자열이 잘린 앞의 문자열로 시작하면
// 뒷부분 문자열, 자르는 단위, 반복횟수 + 1 하여 다음 재귀 호출
// 반복되지 않으면 현재까지의 반복횟수를 기준으로 압축된 결과 문자열 만들기

// 다른 풀이 2
// 압축된 문자열을 만들지 않고 바로 길이를 계산
// Math.log10()을 이용하여 숫자의 자릿수 계산

// 다른 풀이 3
// Stack을 이용해 반복되는 패턴 찾기