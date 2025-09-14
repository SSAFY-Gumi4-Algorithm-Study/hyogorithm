import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] maze;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		maze = new int[n][n];

		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < n; j++) {
				int room = row.charAt(j) - '0';
				if (room == 0) maze[i][j] = 1;
				else maze[i][j] = 0;
			}
		}

		System.out.println(dijkstra());
	}

	static int dijkstra() {
		int[][] dist = new int[n + 1][n + 1];
		for (int[] di : dist) {
			Arrays.fill(di, Integer.MAX_VALUE);			
		}
		dist[0][0] = 0;
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};

		PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparingInt(e -> e.w));
		pq.offer(new Node(0, 0, 0));

		while (!pq.isEmpty()) {
			Node c = pq.poll();

			if (c.w > dist[c.x][c.y]) continue;

			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

				int newDist = dist[c.x][c.y] + maze[nx][ny];
				if (newDist < dist[nx][ny]) {
					dist[nx][ny] = newDist;
					pq.offer(new Node(nx, ny, newDist));
				}
			}
		}

		return dist[n - 1][n - 1];
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
