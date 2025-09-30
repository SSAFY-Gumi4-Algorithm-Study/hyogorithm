import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<Node>[] adj;
	static int[] interview;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[v].add(new Node(u, w));
		}
		
		interview = new int[k];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			interview[i] = Integer.parseInt(st.nextToken());
		}
		
		long[] dist = dijkstra();
		
		int idx = 1;
		long max = -1;
		for (int i = 1; i <= n; i++) {
			if (dist[i] == Long.MAX_VALUE) continue;
			if (dist[i] > max || (dist[i] == max && i < idx)) {
                max = dist[i];
                idx = i;
            }
		}

		System.out.println(idx);
		System.out.println(max);		
	}

	static long[] dijkstra() {
		long[] dist = new long[n + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(e -> e.w));
		
		for (int i : interview) {
			dist[i] = 0;
			pq.offer(new Node(i, 0));
		}
		
		while (!pq.isEmpty()) {
			Node c = pq.poll();
			
			if (c.w > dist[c.to]) continue;
			
			for (Node v : adj[c.to]) {
				long newWeight = c.w + v.w;
				if (newWeight < dist[v.to]) {
					dist[v.to] = newWeight;
					pq.offer(new Node(v.to, newWeight));
				}
			}
		}
		return dist;
	}
}

class Node {
	int to;
	long w;
	Node(int to, long w){
		this.to = to;
		this.w = w;
	}
}
