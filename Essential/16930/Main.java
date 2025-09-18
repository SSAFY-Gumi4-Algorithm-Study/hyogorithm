import java.io.*;
import java.util.*;

public class Main {
	static int n, m, k, answer;
	static char[][] grid;
	static int[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		grid = new char[n][m];
		v = new int[n][m];
		for (int[] row : v) {
			Arrays.fill(row, -1);
		}
		
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				grid[i][j] = row.charAt(j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken()) - 1;
		int y1 = Integer.parseInt(st.nextToken()) - 1;
		int x2 = Integer.parseInt(st.nextToken()) - 1;
		int y2 = Integer.parseInt(st.nextToken()) - 1;
		
		bfs(x1, y1, x2, y2);
		System.out.println(answer);
	}
	
	static void bfs(int sx, int sy, int ex, int ey) {
		Queue<Point> q = new ArrayDeque<>();
		
		q.offer(new Point(sx, sy));
		v[sx][sy] = 0;
		
		while (!q.isEmpty()) {
			Point c = q.poll();
			
			for (int d = 0; d < 4; d++) {
				for (int step = 1; step <= k; step++) {
					int nx = c.x + dx[d] * step;
					int ny = c.y + dy[d] * step;
					
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) break;
					if (grid[nx][ny] == '#') break;
					
					if (v[nx][ny] != -1) {
						if (v[nx][ny] < v[c.x][c.y] + 1) break;
	                    else continue;

					}
					
					q.offer(new Point(nx, ny));
					v[nx][ny] = v[c.x][c.y] + 1;
					
					if (nx == ex && ny == ey) {
	                    answer = v[nx][ny];
						return;
					}					
				}
			}
		}
		answer = -1;
	}
}

class Point {
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
