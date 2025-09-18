import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] t = new int[n + 2];
		int[] p = new int[n + 2];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n + 2];

		for (int i = n; i >= 1; i--) {
			if (i + t[i] - 1 <= n) dp[i] = Math.max(dp[i + 1], dp[i + t[i]] + p[i]);
			else dp[i] = dp[i + 1];
		}
		
		System.out.println(dp[1]);
	}
}
