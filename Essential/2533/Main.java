import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] adj;
    static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		adj = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}

		dp = new int[n + 1][2];
        dfs(1, 0);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	
	static void dfs(int u, int p) {
        dp[u][0] = 0; // u가 얼리어답터가 아닐 때
        dp[u][1] = 1; // u가 얼리어답터일 때(자기 자신)

        for (int v : adj[u]) {
            if (v == p) continue;
            
            dfs(v, u);
            
            dp[u][0] += dp[v][1];
            dp[u][1] += Math.min(dp[v][0], dp[v][1]);
        }
    }
}
