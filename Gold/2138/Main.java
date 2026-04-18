import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String c =  br.readLine();
        String g = br.readLine();

        boolean[] cur = new boolean[n];
        boolean[] goal = new boolean[n];

        for (int i = 0; i < n; i++) {
            cur[i] = c.charAt(i) == '1';
            goal[i] = g.charAt(i) == '1';
        }

        int noPressed = simulate(cur, goal, false); // 첫 스위치 안누른 경우
        int pressed = simulate(cur, goal, true);  // 첫 스위치 누른 경우

        int answer = Math.min(noPressed, pressed);
        if (answer == Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);
    }

    public static int simulate(boolean[] origin, boolean[] goal, boolean firstPressed) {
        boolean[] cur = origin.clone();
        int cnt = 0;

        if (firstPressed) {
            cur[0] = !cur[0];
            if (n > 1) cur[1] = !cur[1];
            cnt++;
        }

        for (int i = 1; i < n; i++) {
            if (cur[i - 1] != goal[i - 1]) {
                cur[i - 1] = !cur[i - 1];
                cur[i] = !cur[i];
                if (i + 1 < n) cur[i + 1] = !cur[i + 1];
                cnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (cur[i] != goal[i]) return Integer.MAX_VALUE;
        }

        return cnt;
    }
}
