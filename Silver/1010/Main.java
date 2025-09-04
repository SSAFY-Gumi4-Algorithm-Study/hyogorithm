import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[m + 1][n + 1];
			
			for (int i = 0; i <= m; i++) {
				for (int j = 0; j <= Math.min(i,  n); j++) {
					if (j == i || j == 0) dp[i][j] = 1;
					else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				}
			}
			
			System.out.println(dp[m][n]);
		}
	}
}
