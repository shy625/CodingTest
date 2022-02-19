/**
 * JO 1828 냉장고
 * @ prob : https://bit.ly/3JBYZIL
 * @ level : 
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JO_1828_냉장고 {

    // 냉장고에 보관되는 화학물질 객체
    static class Chemical implements Comparable<Chemical> {
        int under;  // 최저 보관 온도
        int over;   // 최고 보관 온도

        Chemical(int under, int over) {
            this.under = under;
            this.over = over;
        }

        @Override
        public int compareTo(Chemical c) {
            if(under != c.under) {
                return Integer.compare(under, c.under);
            } else {
                return Integer.compare(over, c.over);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Chemical[] chemicals = new Chemical[N];
        for(int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int under = Integer.parseInt(inputs[0]);
            int over = Integer.parseInt(inputs[1]);
            chemicals[i] = new Chemical(under, over);
        }

        Arrays.sort(chemicals);     // 최저온도가 낮은 순 -> 최고온도가 낮은 순 으로 정렬

        int count = 1;      // 필요한 냉장고 개수
        int underMax = Integer.MIN_VALUE;   // 겹치는 온도범위 중 최저온도의 최댓값
        int overMin = Integer.MAX_VALUE;    // 겹치는 온도범위 중 최고온도의 최솟값
        for(int i = 0; i < N; i++) {
            if(overMin < chemicals[i].under) {      // 현재까지 겹치는 온도범위의 최고온도보다 다음 화학물의 최저온도가 큰 경우
                count++;    // 냉장고 개수 증가
                underMax = chemicals[i].under;      // 온도범위 초기화 
                overMin = chemicals[i].over;        // 온도범위 초기화
            } else {    
                underMax = Math.max(underMax, chemicals[i].under);      // 겹치는 온도범위의 최저온도의 최댓값 설정
                overMin = Math.min(overMin, chemicals[i].over);         // 겹치는 온도범위의 최고온도의 최솟값 설정
            }
        }

        System.out.println(count);

        br.close();
    }
}