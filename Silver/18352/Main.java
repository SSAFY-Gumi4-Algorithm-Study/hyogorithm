import java.io.*;
import java.util.*;

public class Main {
	static int n, k, x;
	static List<List<Integer>> adj = new ArrayList<>();;
	static List<Integer> answer = new ArrayList<>();;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());	

		for(int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
		}
		
		dijkstra();
	}
	
	static void dijkstra() {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[x] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		pq.offer(new int[] {0, x});
		
		while(!pq.isEmpty()) {
			int[] cCity = pq.poll();
			
			for(int nCity : adj.get(cCity[1])) {
				int newCost = cCity[0] + 1;
				if(newCost < dist[nCity]) {
					dist[nCity] = newCost;
					pq.offer(new int[] {newCost, nCity});
				}
				
			}
		}
		
		for(int i = 0; i <= n; i++) {
			if(dist[i] == k) {
				answer.add(i);
			}
		}
		
		if(answer.size() == 0) {
			System.out.println(-1);
		} else {
			Collections.sort(answer);
			
			for(int ans : answer) {
				System.out.println(ans);
			}			
		}
	}
}
