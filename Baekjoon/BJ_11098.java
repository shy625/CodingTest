/**
 * @ BJ 11098 첼시를 도와줘!
 * @ prob : https://www.acmicpc.net/problem/11098
 */

import java.util.Scanner;

public class BJ_11098 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Player[] player = new Player[n];

        for(int i = 0; i < n; i++) {
            int p = sc.nextInt();
            player[i] = new Player();
            for(int j = 0; j < p; j++) {
                int cost = sc.nextInt();
                String name = sc.next();
                if(cost > player[i].getCost()) {
                    player[i].setCost(cost);
                    player[i].setName(name);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            System.out.println(player[i].getName());
        }
    }
}

class Player {
    private int cost = 0;
    private String name = "";

    Player() {
        this(0, "");
    }

    Player(int cost, String name) {
        this.cost = cost;
        this.name = name;
    }

    void setCost(int cost) {
        this.cost = cost;
    }

    void setName(String name) {
        this.name = name;
    }

    int getCost() {
        return this.cost;
    }

    String getName() {
        return this.name;
    }
}