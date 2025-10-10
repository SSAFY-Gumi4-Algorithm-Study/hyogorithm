import java.io.*;
import java.util.*;

public class Main {
	static int n, sx, sy;
	static int[][] grid;
	static int[] dx = {-1, 0, 0, 1}; // 위 왼 오 아래
	static int[] dy = {0, -1, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		grid = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 9) {
					sx = i;
					sy = j;
				}
			}
		}

		grid[sx][sy] = 0;
		int shark = 2;
		int eat = 0;
		int time = 0;

		while (true) {
			Point p = find(sx, sy, shark);
			if (p == null) break;

			time += p.dist;
			eat++;
			grid[p.x][p.y] = 0;
			sx = p.x; 
			sy = p.y;

			if (eat == shark) {
				shark++;
				eat = 0;
			}
		}

		System.out.println(time);
	}

	static Point find(int startX, int startY, int size) {
		boolean[][] v = new boolean[n][n];
      
		PriorityQueue<Point> pq = new PriorityQueue<>(
				(a, b) -> {
					if (a.dist != b.dist) return a.dist - b.dist;
					if (a.x != b.x)     return a.x - b.x;
					return a.y - b.y;
				}
		);
		
		pq.offer(new Point(startX, startY, 0));
		v[startX][startY] = true;

		while (!pq.isEmpty()) {
			Point c = pq.poll();

			if (grid[c.x][c.y] > 0 && grid[c.x][c.y] < size) {
				return c;
			}

			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d], ny = c.y + dy[d];
              
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if (v[nx][ny]) continue;
              
				if (grid[nx][ny] <= size) {
					v[nx][ny] = true;
					pq.offer(new Point(nx, ny, c.dist + 1));
				}
			}
		}
		return null;
	}

}

class Point {
	int x, y, dist;
	Point(int x, int y, int dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}
