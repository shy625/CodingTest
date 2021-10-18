/**
 * @ BJ 7568 덩치
 * @ prob : https://www.acmicpc.net/problem/7568
 */

import java.util.Scanner;

public class BJ_7568_덩치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Bulk[] people = new Bulk[n];

        for(int i = 0; i < n; i++) {
            people[i] = new Bulk(sc.nextInt(), sc.nextInt());
        }

        for(int i = 0; i < n; i++) {
            System.out.print(getRank(people[i], people) + " ");
        }

        sc.close();
    }

    static int getRank(Bulk b, Bulk[] people) {
        int count = 0;
        for(int i = 0; i < people.length; i++) {
            if(b.compareTo(people[i]) == -1) {
                count++;
            }
        }
        return count + 1;
    }
}

class Bulk implements Comparable {
    int tall;
    int weight;

    Bulk(int tall, int weight) {
        this.tall = tall;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        Bulk b = (Bulk)o;
        if((this.tall > b.tall) && (this.weight > b.weight)) {
            return 1;
        } else if ((this.tall < b.tall) && (this.weight < b.weight)) {
            return -1;
        } else {
            return 0;
        }
    }
}

// 다른 풀이 1
// 이차원 배열로 풀이

// int[][] sizes = new int[][3];   // tall, weight, rank
// for(int i = 0; i < n; i++) {
//     for(int j = 0; j < n; j++) {
//         if(i == j) {
//             continue;
//         }
//         if((sizes[i][0] < sizes[j][0]) && (sizes[i][1] < sizes[j][1])) {
//             sizes[i][2]++;
//         }
//     }
// }
// for(int i = 0; i < n; i++) {
//     System.out.print(sizes[i][2] + " ");
// }