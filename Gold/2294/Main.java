import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 동전 종류 n개
		int k = Integer.parseInt(st.nextToken()); // 줘야할 거스름돈
		int[] c = new int[n]; // 각 동전의 가치

		for (int i = 0; i < n; i++) {
			c[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[k + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = c[i]; j <= k; j++) {
				if (dp[j - c[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - c[i]] + 1);
				}
			}
		}
		
		if (dp[k] == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dp[k]);
	}
}
