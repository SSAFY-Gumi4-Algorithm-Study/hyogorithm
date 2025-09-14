import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<Node>[] adj;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[n + 1];
			
			for (int i = 0; i <= n; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				adj[b].add(new Node(a, s));
			}
		
			int[] result = dijkstra(c);
			
			int cnt = 0;
			int time = 0;
			for (int di : result) {
				if (di == Integer.MAX_VALUE) continue;
				cnt++;
				time = Math.max(di, time);
			}
			System.out.println(cnt + " " + time);
		}
	}
	
	static int[] dijkstra(int start) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparingInt(e -> e.w));
		pq.offer(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node c = pq.poll();
			
			if (c.w > dist[c.to]) continue;
			
			for (Node v : adj[c.to]) {
				int newDist = dist[c.to] + v.w;
				if (newDist < dist[v.to]) {
					dist[v.to] = newDist;
					pq.offer(new Node(v.to, newDist));
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
