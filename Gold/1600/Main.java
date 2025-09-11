import java.io.*;
import java.util.*;

public class Main {
	static int k, w, h, answer;
	static int[][] grid;
	static boolean[][][] v;
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2}; // 말
	static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		grid = new int[h][w];
		v = new boolean[h][w][k + 1];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		System.out.println(answer);
	}

	static void bfs() {
		Queue<Point> q = new ArrayDeque<>();

		q.offer(new Point(0, 0, 0, 0));
		v[0][0][0] = true;
		

		while (!q.isEmpty()) {
			Point c = q.poll();

			if (c.x == h - 1 && c.y == w - 1) {
				answer = c.step;
				return;
			}				

			for (int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];

				if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
				if (grid[nx][ny] == 1) continue;

				if (!v[nx][ny][c.horse]) {
					q.offer(new Point(nx, ny, c.horse, c.step + 1));
					v[nx][ny][c.horse] = true;
				}
			}
			
			if (c.horse < k) {
				for (int d = 0; d < 8; d++) {
					int nx = c.x + hx[d];
					int ny = c.y + hy[d];
					
					if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
					if (grid[nx][ny] == 1) continue;
					
					if (!v[nx][ny][c.horse + 1]) {
						q.offer(new Point(nx, ny, c.horse + 1, c.step + 1));
						v[nx][ny][c.horse + 1] = true;
					}
				}
			}
		}
		answer = -1;
	}
}

class Point {
	int x, y, horse, step;

	Point(int x, int y, int horse, int step) {
		this.x = x;
		this.y = y;
		this.horse = horse;
		this.step = step;
	}
}
