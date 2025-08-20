import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static List<List<Integer>> adj;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		
		adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
			adj.get(b).add(a);
			
		}
		
		v = new boolean[n + 1];
		System.out.println(bfs(p1, p2));
	}

	static int bfs(int s, int e) {
		Queue<int[]> q = new ArrayDeque<>();
		v[s] = true;
		q.add(new int[] {s, 0});
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			
			if (c[0] == e) {
				return c[1];
			}

			for (int n : adj.get(c[0]) ) {
				if (!v[n]) {
					v[n] = true;
					q.add(new int[] {n, c[1] + 1});
				}
			}
		}
		return -1;
	}
}
