import java.io.*;
import java.util.*;

public class Main {
	static int n, maxHeight, maxSafe;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		maxHeight = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > maxHeight) maxHeight = map[i][j];
			}
		}

		for (int r = 0; r < maxHeight; r++) {
			v = new boolean[n][n];
			int safe = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!v[i][j] && map[i][j] > r) {
						bfs(i, j, r);
						safe++;
					}
				}
			}
			maxSafe = Math.max(maxSafe, safe);
		}
		
		System.out.println(maxSafe);
	}

	static void bfs(int sx, int sy, int r) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(sx, sy));
		v[sx][sy] = true;
		
		while (!q.isEmpty()) {
			Point c = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];
				
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny] && map[nx][ny] > r) {
					v[nx][ny] = true;
					q.offer(new Point(nx, ny));
				}
			}
		}
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
