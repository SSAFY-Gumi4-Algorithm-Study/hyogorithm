import java.io.*;
import java.util.*;

public class Main{
	static int n;
	static char[][] grid1, grid2;
	static boolean v[][];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		grid1 = new char[n][n];
		grid2 = new char[n][n];
		v = new boolean[n][n];

		for(int i = 0; i < n; i++){
			String row = br.readLine();
			for(int j = 0; j < n; j++){
				char color = row.charAt(j);
				grid1[i][j] = color;
				if (color == 'G') color = 'R';
				grid2[i][j] = color;
			}
		}

		int cnt = 0;

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if (!v[i][j]) {
					char current = grid1[i][j];
					bfs(i, j, grid1, current);
					cnt++;
				}
			}
		}
		System.out.print(cnt + " ");

		cnt = 0;
		v = new boolean[n][n];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if (!v[i][j]) {
					char current = grid2[i][j];
					bfs(i, j, grid2, current);
					cnt++;
				}
			}
		}
		System.out.print(cnt);
	}

	public static void bfs(int sx, int sy, char[][] grid, char color){
		Queue<Point> q = new ArrayDeque<>();
		v[sx][sy] = true;
		q.add(new Point(sx, sy));

		while (!q.isEmpty()) {
			Point c = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

				if (!v[nx][ny] && grid[nx][ny] == color) {
					v[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
	}
}

class Point{
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
