import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            String result = br.readLine();
            int score = 0;
            int cur = 0;
            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(i) == 'O') {
                    cur++;
                    score += cur;
                } else {
                    cur = 0;
                }
            }
            System.out.println(score);
        }
        br.close();
    }
}
