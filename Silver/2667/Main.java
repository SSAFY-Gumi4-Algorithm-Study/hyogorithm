import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		v = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String row = br.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = row.charAt(j) - '0';
			}

		}
		
		List<Integer> answer = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
                if (!v[i][j] && map[i][j] == 1) {
				 	int count = bfs(i, j);
				 	answer.add(count);
				}
			}
		}

		Collections.sort(answer);
		System.out.println(answer.size());
		for(int c : answer) {
			System.out.println(c);
		}
	}
	
	static int bfs(int sx, int sy) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(sx, sy));
		v[sx][sy] = true;
		int count = 1;
		
		while(!q.isEmpty()) {
			Point c = q.remove();
			
			for(int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny] && map[nx][ny] == 1) {
					v[nx][ny] = true;
					q.add(new Point(nx, ny));
					count++;
				}
			}
		}
		return count;
	}
}

class Point{
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
