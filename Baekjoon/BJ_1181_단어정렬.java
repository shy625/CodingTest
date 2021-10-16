/**
 * @ BJ 1181 단어 정렬
 * @ prob : https://www.acmicpc.net/problem/1181
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BJ_1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.valueOf(br.readLine());
        String[] words = new String[n];
        for(int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
            }

        });

        sb.append(words[0] + '\n');
        for(int i = 1; i < n; i++) {
            if(words[i-1].equals(words[i])) {
                continue;
            }
            sb.append(words[i] + '\n');
        }
        System.out.println(sb);

        br.close();
    }
}

// 다른 풀이 1
// 이차원 리스트를 사용 -> 단어의 길이를 index로 하는 리스트 -> 그 길이에 해당하는 단어를 가지는 리스트

// List<List<String>> wordsLength = new ArrayList<>();     // wordsLength의 index : 단어의 길이
// for(int i = 0; i <= 50; i++) {
//     wordsLength.add(new ArrayList<>());
// }
// 
// 각 단어의 길이를 index로 하여 wordsLength 리스트에 추가
// -> 길이가 i인 모든 단어는 wordsLength 리스트의 i번째 index에 있는 리스트에 추가됨
// for(int i = 0; i < n; i++) {
//     String word = br.readLine();
//     wordsLength.get(word.length()).add(word);
// }
// 
// for(int i = 0; i <= 50; i++) {
//     if(wordsLength.get(i).size() > 0) {
//         wordsLength.get(i).sort(Comparator.naturalOrder());
//         sb.append(wordsLength.get(i).get(0) + '\n');
//         for(int j = 1; j < wordsLength.get(i).size(); j++) {
//             if(wordsLength.get(i).get(j-1).equals(wordsLength.get(i).get(j))) {
//                 continue;
//             }
//             sb.append(wordsLength.get(i).get(j) + '\n');
//         }
//     }
// }
// System.out.println(sb);

// 다른 풀이 2
// 처음에 단어를 입력받을 때 Set을 사용하여 바로 중복 제거 -> Set을 정렬 후 출력
// 또는 바로 TreeSet 이용 -> TreeSet은 값을 추가할 때 자동으로 정렬하여 저장

// Set<String> wordSet = new TreeSet<>(new Comparator<String>() {
//     @Override
//     public int compare(String o1, String o2) {
//         return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
//     } 
// });
// 
// for(int i = 0; i < n; i++) {
//     wordSet.add(br.readLine());
// }
// 
// Iterator iter = wordSet.iterator();
// while(iter.hasNext()) {
//     sb.append(iter.next() + "\n");
// }
// System.out.println(sb);