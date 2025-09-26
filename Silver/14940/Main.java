import java.io.*;
import java.util.*;

public class Main {
	static int n, m, sx, sy;
	static int[][] map, dist;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		dist = new int[n][m];	

		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], -1);
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					sx = i;
					sy = j;
				}
			}
		}
		
		bfs();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) sb.append(0).append(" ");
				else sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(sx, sy));
		dist[sx][sy] = 0;

		while (!q.isEmpty()) {
			Point c = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 0 && dist[nx][ny] == -1) {
					q.offer(new Point(nx, ny));
					dist[nx][ny] = dist[c.x][c.y] + 1;
				}
			}
		}
	}
}

class Point {
	int x, y;

	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
