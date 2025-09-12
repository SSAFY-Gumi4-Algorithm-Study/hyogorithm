import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static List<Node>[] adj;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
	
			adj = new ArrayList[n + 1];
			
			for (int i = 0; i <= n; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				adj[a].add(new Node(b, c));
				adj[b].add(new Node(a, c));
			}
			
			int k = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[][] results = new int[k][];
			
			for (int i = 0; i < k; i++) {
				int friend = Integer.parseInt(st.nextToken());
				results[i] = dijkstra(friend);
			}

			int answer = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= n; i++) {
				int sum = 0;
				for (int j = 0; j < k; j++) {
					sum += results[j][i];
				}
				
				if (min > sum) {
					min = sum;
					answer = i;
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static int[] dijkstra(int start) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
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
