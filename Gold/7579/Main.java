import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] mem = new int[n];
		int[] cost = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			mem[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sum += cost[i];
		}

		int[] dp = new int[sum + 1];
		for (int i = 0; i < n; i++) {
			for (int j = sum; j >= cost[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - cost[i]]+ mem[i]);				
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i <= sum; i++) {
			if (dp[i] >= m) answer = Math.min(answer, i);
		}

		System.out.println(answer);
	}
}
