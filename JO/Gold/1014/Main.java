import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String devil = br.readLine();
        String angel = br.readLine();

        String[] bridge = {devil, angel};

        int m = str.length();
        int n = devil.length();

        int[][][] dp = new int[2][m][n];

        for (int b = 0; b < 2; b++) {
            for (int j = 0; j < n; j++) {
                if (bridge[b].charAt(j) == str.charAt(0)) {
                    dp[b][0][j] = 1;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int b = 0; b < 2; b++) {
                for (int j = 0; j < n; j++) {
                    if (bridge[b].charAt(j) != str.charAt(i)) continue;

                    for (int k = 0; k < j; k++) {
                        dp[b][i][j] += dp[1 - b][i - 1][k];
                    }
                }
            }
        }

        int answer = 0;
        for (int b = 0; b < 2; b++) {
            for (int j = 0; j < n; j++) {
                answer += dp[b][m - 1][j];
            }
        }

        System.out.println(answer);
    }
}
