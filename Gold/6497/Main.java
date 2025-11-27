import java.io.*;
import java.util.*;

public class Main {
	static int[][] cost;
	static int[] parent;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if (v == 0 && e == 0) break;
			
			cost = new int[e][3];
			int sum = 0;
			
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				cost[i][0] = Integer.parseInt(st.nextToken());
				cost[i][1] = Integer.parseInt(st.nextToken());
				cost[i][2] = Integer.parseInt(st.nextToken());
				sum += cost[i][2];
			}
			
			Arrays.sort(cost, (a, b) -> a[2] - b[2]);
			
			parent = new int[v + 1];
			
			for (int i = 1; i <= v; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < e; i++) {
				if (find(cost[i][0]) != find(cost[i][1])) {
					union(cost[i][0], cost[i][1]);
					sum -= cost[i][2];
				}
			}
			System.out.println(sum);
		}
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
