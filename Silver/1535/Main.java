import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		int[] life = new int[n];
		int[] joy = new int[n];

		for (int i = 0; i < n; i++) {
			life[i] = Integer.parseInt(st.nextToken());	
			joy[i] = Integer.parseInt(st2.nextToken());
		}

		int[] dp = new int[101];

		for (int j = 0; j < n; j++) {
			for (int i = 100; i >= life[j]; i--) {
				dp[i] = Math.max(dp[i - life[j]] + joy[j], dp[i]);
			}
		}
		
		int max = 0;
		for (int i = 1; i < 100; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
