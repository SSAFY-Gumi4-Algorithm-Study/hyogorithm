import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String id = br.readLine();

        int[] cost = new int[26];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int ins = Integer.parseInt(st.nextToken());
            int del = Integer.parseInt(st.nextToken());
            cost[ch - 'a'] = Math.min(ins, del);
        }

        int[][] dp = new int[m][m];
        for (int len = 2; len <= m; len++) {
            for (int i = 0; i + len - 1 < m; i++) {
                int j = i + len - 1;

                int left = dp[i + 1][j] + cost[id.charAt(i) - 'a'];
                int right = dp[i][j - 1] + cost[id.charAt(j) - 'a'];
                dp[i][j] = Math.min(left, right);

                if (id.charAt(i) == id.charAt(j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                }
            }
        }

        System.out.println(dp[0][m - 1]);
    }
}
