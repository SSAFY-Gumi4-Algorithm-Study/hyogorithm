import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<Node>[] adj;
	static int[] path;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Node(v, w));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		path = new int[n + 1];
		int minCost = dijkstra(s, e);
		System.out.println(minCost);
		
		List<Integer> route = new ArrayList<>();
	    for (int at = e; at != 0; at = path[at]) {
	        route.add(at);
	        if (at == s) break;
	    }
	    Collections.reverse(route);

	    System.out.println(route.size());
	    for (int node : route) {
	        System.out.print(node + " ");
	    }
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
					path[v.to] = c.to;
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
