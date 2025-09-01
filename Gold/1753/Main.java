import java.io.*;
import java.util.*;

public class Main {
	static int V, K;
	static List<List<Node>> adj = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= V; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj.get(u).add(new Node(v, w));
		}
		
		int[] result = dijkstra();
		
		for (int i = 1; i <= V; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }
	}
	
	static int[] dijkstra() {
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
		pq.offer(new Node(K, 0));
		
		while (!pq.isEmpty()) {
			Node c = pq.poll();
			
            if (c.w > dist[c.to]) continue;
			
			for (Node v : adj.get(c.to)) {
				int newWeight = c.w + v.w;
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
	int to, w;
	Node(int to, int w){
		this.to = to;
		this.w = w;
	}
}
