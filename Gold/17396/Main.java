import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<Node>[] adj;
	static int[] see;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		see = new int[n];
		adj = new ArrayList[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			see[i] = Integer.parseInt(st.nextToken());
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

		System.out.println(dijkstra(0, n - 1));
	}

	static long dijkstra(int start, int end) {
		long[] dist = new long[n];

		Arrays.fill(dist, Long.MAX_VALUE);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(e -> e.w));
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node c = pq.poll();

			if (c.w > dist[c.to]) continue;

			for (Node v : adj[c.to]) {
				if (see[v.to] == 1 && v.to != end) continue;

				long newCost = dist[c.to] + v.w;

				if (newCost < dist[v.to]) {
					dist[v.to] = newCost;
					pq.offer(new Node(v.to, newCost));
				}

			}
		}
		return dist[end] == Long.MAX_VALUE ? -1 : dist[end];
	}
}

class Node {
	int to;
	long w;

	Node (int to, long w){
		this.to = to;
		this.w = w;
	}
}
