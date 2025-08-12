import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] grid;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		while(true) {
			tc++;
			n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				break;
			}
			
			grid = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.printf("Problem %d: %d%n", tc, dijkstra());
		}
		
	}
	
	static int dijkstra() {
		int[][] dist = new int[n][n];
		for(int[] row : dist) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		dist[0][0] = grid[0][0];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		pq.offer(new int[] {grid[0][0], 0, 0});
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		while(!pq.isEmpty()) {
			int[] c = pq.poll();
			
			if(c[1] == n - 1 && c[2] == n - 1) {
				return c[0];
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = c[1] + dx[d];
				int ny = c[2] + dy[d];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
					int newCost = c[0] + grid[nx][ny];
					if(newCost < dist[nx][ny]) {
						dist[nx][ny] = newCost;
						pq.offer(new int[] {newCost, nx, ny});
					}
				}
			}
		}
		return -1;
	}
	
}
