import java.io.*;
import java.util.*;

public class Main{
	static boolean v[];
	static int parent[];
	static List<Integer>[] adj;

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		v = new boolean[n + 1];
		parent = new int[n + 1];
		adj = new ArrayList[n + 1];

		for(int i = 0; i <= n; i++){
			adj[i] = new ArrayList<>();
		}

		for(int i = 0; i < n - 1; i++){
			StringTokenizer st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		bfs(1);

		for(int i = 2; i < parent.length; i++){
			System.out.println(parent[i]);
		}
	}

	public static void bfs(int root){
		Queue<Integer> q = new ArrayDeque<>();
		v[root] = true;
		q.add(root);
		
		while (!q.isEmpty()) {
			int c = q.poll();
			for (int node : adj[c]) {
				if (!v[node]) {
					v[node] = true;
					q.add(node);
					parent[node] = c;
				}
			}
		}
	}
}
