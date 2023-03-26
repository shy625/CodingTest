import java.util.*;

public class BJ_S5_4673_셀프넘버 {

    static boolean[] selfNums;

    public static void main(String[] args) {
        selfNums = new boolean[10001];

        Arrays.fill(selfNums, true);
        selfNums[0] = false;
        for (int i = 1; i < selfNums.length; i++) {
            if (selfNums[i]) {
                d(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < selfNums.length; i++) {
            if (selfNums[i]) {
                sb.append(i).append(System.lineSeparator());
            }
        }
        System.out.print(sb.toString());
    }

    private static void d(int n) {
        while (n <= 10000) {
            int sum = n;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            if (sum > 10000) {
                return;
            }
            if (!selfNums[sum]) {
                return;
            } else {
                selfNums[sum] = false;
                n = sum;
            }
        }
    }
}

// 풀이 1
// 셀프넘버 여부를 체크할 10001 길이의 boolean 배열 생성
// 임의의 두 수에 의해 계산된 수가 같다면 그 이후로 계산되는 모든 수는 동일 -> 한번 나온 수에 대해 다시 계산할 필요 X
// 1부터 10000까지의 수에 대해 셀프넘버라면 셀프넘버 계산 함수 진행
// 셀프넘버 계산 함수
// 주어진 수에 대해 해당 수 + 각 자리수 계산
// 계산된 수가 이미 다른 수에 의해 생성된 수면 종료
// 계산된 수가 아직 다른 수에 의해 생성된 수가 아니라면 셀프넘버 false 체크 후 해당 수로 다시 계산
// 셀프넘버인 수만 출력

// 풀이 2
// 셀프넘버 체크용 배열 생성
// 1부터 10000의 수에 대해 셀프넘버 계산
// 계산 결과로 나온 수를 셀프넘버 false 체크
// 셀프넘버인 수만 출력