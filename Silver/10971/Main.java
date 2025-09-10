import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] w;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		w = new int[n][n];
		dp = new int[n][1 << 16]; // 2^16
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());				
			}
		}

		System.out.println(TSP(0, 1));
	}
	
	static int TSP(int c, int visit) {
		if (visit == (1 << n) - 1) {// 모든 도시 방문
			if (w[c][0] == 0) return Integer.MAX_VALUE;
			return w[c][0];
		}
		
		if (dp[c][visit] != 0) return dp[c][visit];
		
		dp[c][visit] = Integer.MAX_VALUE;
		
		for (int i = 1; i < n; i++) {
			if (w[c][i] == 0) continue; // 경로가 없으면
			if ((visit & (1 << i)) != 0) continue; // 이미 방문했으면
			
			int temp = TSP(i, visit | (1 << i)); // visit에 도시 i를 방문했다고 표시
			if (temp == Integer.MAX_VALUE) continue;
			dp[c][visit] = Math.min(dp[c][visit], temp + w[c][i]);
		}
		
		return dp[c][visit];
	}		
}
