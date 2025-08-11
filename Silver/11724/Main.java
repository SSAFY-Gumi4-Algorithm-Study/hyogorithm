import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> adj;
	static boolean[] v;
	static int cnt;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		adj = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			// 양방향 연결
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
		v = new boolean[n + 1];
		cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(!v[i]) {
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static void bfs(int s) {
		Queue<Integer> q = new ArrayDeque<>();
		v[s] = true;
		q.add(s);
		
		while(!q.isEmpty()) {
			int c = q.remove();
			
			for(int n : adj.get(c)) {
				if(!v[n]) {
					v[n] = true;
					q.add(n);
				}
			}
		}
	}
}
