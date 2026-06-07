import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        if (s.charAt(0) != '0') {
            dp[1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            int num = Integer.parseInt(s.substring(i - 2, i));
            if (num >= 10 && num <= 34) {
                dp[i] += dp[i - 2];
            }
        }

        System.out.println(dp[n]);
    }
}
