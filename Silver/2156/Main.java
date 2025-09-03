import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] wine = new int[n];

		for (int i = 0; i < n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[n + 1];

		if (n >= 1) dp[0] = wine[0];
		if (n >= 2) dp[1] = wine[0] + wine[1];
		if (n >= 3) dp[2] = Math.max(Math.max(wine[0] + wine[1], wine[0] + wine[2]), wine[1] + wine[2]);

		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + wine[i]), dp[i - 3] + wine[i - 1] + wine[i]);
		}

		int max = 0;
		for (int i : dp) {
			max = Math.max(max, i);
		}
		
		System.out.println(max);
	}
}
