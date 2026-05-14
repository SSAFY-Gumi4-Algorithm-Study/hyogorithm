import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] w = new int[N];
        int[] p = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[W + 1];
        for (int i = 0; i < N; i++) {
            for (int j = w[i]; j <= W; j++) {
                dp[j] = Math.max(dp[j], dp[j - w[i]]+ p[i]);
            }
        }

        System.out.println(dp[W]);
    }
}
