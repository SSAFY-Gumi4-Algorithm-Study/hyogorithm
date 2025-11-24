import java.io.*;
import java.util.*;

public class Main {
	static int[][] cost;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		cost = new int[m][3];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cost, (a, b) -> a[2] - b[2]);

		parent = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		int sum = 0;
		int max = 0;
		for (int i = 0; i < m; i++) {
			if (find(cost[i][0]) != find(cost[i][1])) {
				union(cost[i][0], cost[i][1]);
				sum += cost[i][2];
				max = Math.max(max, cost[i][2]);
			}
		}
		System.out.println(sum - max);
	}
	
	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb) return false;
		
		if (pa < pb) parent[pb] = pa;
		else parent[pa] = pb;
		return true;
	}
}
