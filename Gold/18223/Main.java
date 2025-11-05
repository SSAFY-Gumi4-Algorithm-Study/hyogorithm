import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<Node>[] adj;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Node(v, w));
			adj[v].add(new Node(u, w));
		}

		int minDist = dijkstra(1, n);
		int saveDist = dijkstra(1, p) + dijkstra(p, n);
		if (minDist == saveDist) System.out.println("SAVE HIM");
		else System.out.println("GOOD BYE");
	}
	
	static int dijkstra(int start, int end) {
		int[] dist = new int[n + 1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
		pq.offer(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node c = pq.poll();
			
			if (c.w > dist[c.to]) continue;
			
			for (Node v : adj[c.to]) {
				int newCost = dist[c.to] + v.w;
				
				if (newCost < dist[v.to]) {
					dist[v.to] = newCost;
					pq.offer(new Node(v.to, newCost));
				}
			}
		}
		return dist[end];
	}
}

class Node {
	int to, w;
	
	Node (int to, int w){
		this.to = to;
		this.w = w;
	}
}
