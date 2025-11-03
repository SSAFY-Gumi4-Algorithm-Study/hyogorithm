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
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		long a1 = dijkstra(1, v1);
        long a2 = dijkstra(v1, v2);
        long a3 = dijkstra(v2, n);

        long b1 = dijkstra(1, v2);
        long b2 = dijkstra(v2, v1);
        long b3 = dijkstra(v1, n);

        long route1 = (a1 >= Integer.MAX_VALUE || a2 >= Integer.MAX_VALUE || a3 >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : (a1 + a2 + a3);
        long route2 = (b1 >= Integer.MAX_VALUE || b2 >= Integer.MAX_VALUE || b3 >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : (b1 + b2 + b3);

        long answer = Math.min(route1, route2);
        System.out.println(answer >= Integer.MAX_VALUE ? -1 : answer);
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
