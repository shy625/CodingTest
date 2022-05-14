import java.util.Scanner;

public class BJ_곰곰컵_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        int maxBev = A / 2 + B;

        System.out.println(N >= maxBev ? maxBev : N);

        sc.close();
    }
}
