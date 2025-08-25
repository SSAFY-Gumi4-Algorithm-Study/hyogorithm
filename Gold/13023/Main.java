import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<List<Integer>> adj = new ArrayList<>();
	static boolean[] v;
	static boolean found = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		
		v = new boolean[n];
		for (int i = 0; i < n; i++) {
			dfs(i, 1);
			if (found) break;
		}

		if (found) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	static void dfs(int c, int depth) {
		if (depth == 5) {
			found = true;
			return;
		}
		
		v[c] = true;
      
		for (int next : adj.get(c)) {
			if (!v[next]) {
				dfs(next, depth + 1);
				if (found) return;
			}
		}
		
		v[c] = false;
	}
}
