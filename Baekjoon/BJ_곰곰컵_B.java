import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ_곰곰컵_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int emoCnt = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.equals("ENTER")) {
                emoCnt += set.size();
                set.clear();
            } else {
                set.add(input);
            }
        }
        emoCnt += set.size();

        System.out.println(emoCnt);

        br.close();
    }
}
