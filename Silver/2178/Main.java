import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] grid;
	static boolean[][] v;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		grid = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				grid[i][j] = row.charAt(j) - '0';
			}
		}
		
		v = new boolean[n][m];		
		System.out.println(bfs(0, 0));
	}

	static int bfs(int sx, int sy) {
		Queue<Point> q = new ArrayDeque<>();
		v[sx][sy] = true;
		q.add(new Point(sx, sy, 1));
		
		while(!q.isEmpty()) {
			Point c = q.poll();
			
			if (c.x == n - 1 && c.y == m - 1) {
				return c.d;
			}

			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !v[nx][ny] && grid[nx][ny] == 1) {
					v[nx][ny] = true;
					q.add(new Point(nx, ny, c.d + 1));
				}
			}
		}
		return -1;
	}
}

class Point{
	int x, y, d;
	
	Point(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
	}
}
