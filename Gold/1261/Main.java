import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = row.charAt(j) - '0';
			}
		}
		System.out.println(dijkstra());
	}

	static int dijkstra() {
		int[][] dist = new int[n][m];
		for(int[] row : dist) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		dist[0][0] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
		pq.offer(new Node(0, 0, 0));

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		while (!pq.isEmpty()) {
			Node c = pq.poll();

			if (c.x == n - 1 && c.y == m - 1) return c.w;

			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					int newWeight = c.w + map[nx][ny];					
					if (newWeight < dist[nx][ny]) {
						dist[nx][ny] = newWeight;
						pq.offer(new Node(nx, ny, newWeight));
					}
				}
			}
		}

		return -1;
	}

}

class Node {
	int x, y, w;
	Node(int x, int y, int w){
		this.x = x;
		this.y = y;
		this.w = w;
	}
}
