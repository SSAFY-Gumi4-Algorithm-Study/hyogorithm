import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stair = new int[n + 1];

		for (int i = 0; i < n; i++) {
			stair[i + 1] = Integer.parseInt(br.readLine());	
		}

		int[] dp = new int[n + 1];
		if (n >= 1) dp[1] = stair[1];
		if (n >= 2) dp[2] = stair[1] + stair[2];

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i] + stair[i - 1]);
		}
		
		System.out.println(dp[n]);
	}
}
