/**
 * BJ 10814 나이순 정렬
 * @ prob : https://www.acmicpc.net/problem/10814
 * @ level : S5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10814_나이순정렬 {

    static class Member implements Comparable<Member> {
        int age;
        int join;
        String name;

        Member(int age, int join, String name) {
            this.age = age;
            this.join = join;
            this.name = name;
        }

        @Override
        public int compareTo(Member m) {
            if(age != m.age) {
                return age - m.age;
            } else {
                return join - m.join;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Member[] members = new Member[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[i] = new Member(age, i, name);
        }

        Arrays.sort(members);

        for(int i = 0; i < N; i++) {
            sb.append(members[i].age).append(" ").append(members[i].name).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }
}

// 다른 풀이 1
// 나이를 index로 하는 StringBuilder 배열을 생성하고 입력이 들어오면 나이에 맞게 각 StringBuilder에 정보를 append한다.
// 출력 시 index가 작은 순서부터 StringBuilder를 모두 출력한다.
// https://www.acmicpc.net/source/41172393