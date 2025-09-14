import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = new BigDecimal(st.nextToken()).movePointRight(2).intValueExact();

			if (n == 0 && m == 0) break;
			
			int[] c = new int[n + 1];
			int[] p = new int[n + 1];
			
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				c[i] = Integer.parseInt(st.nextToken());
				p[i] = new BigDecimal(st.nextToken()).movePointRight(2).intValueExact();
			}
			
			int[][] dp = new int[n + 1][m + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= m; j++) {
					if (p[i] > j) dp[i][j] = dp[i - 1][j];
					else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - p[i]] + c[i]);
				}
			}
			
			System.out.println(dp[n][m]);
		}
	}	
}
