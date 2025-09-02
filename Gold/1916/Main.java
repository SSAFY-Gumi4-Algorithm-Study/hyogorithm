import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<List<Node>> adj = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj.get(u).add(new Node(v, w));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		System.out.println(dijkstra(s, e));
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
			if (c.to == end) return c.w;

			for (Node v : adj.get(c.to)) {
				int newWeight = c.w + v.w;									
				if (newWeight < dist[v.to]) {
					dist[v.to] = newWeight;
					pq.offer(new Node(v.to, newWeight));
				}
			}
		}

		return -1;
	}

}

class Node {
	int to, w;
	Node(int to, int w){
		this.to = to;
		this.w = w;
	}
}
