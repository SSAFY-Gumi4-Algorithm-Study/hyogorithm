import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static char[][] school;
	static boolean[][] v;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		school = new char[n][m];
		int sx = 0;
		int sy = 0;
		for(int i = 0; i < n; i++) {
			String row = br.readLine();
			for(int j = 0; j < m; j++) {
				school[i][j] = row.charAt(j);
				if (row.charAt(j) == 'I') {
					sx = i;
					sy = j;
				}
			}
		}
		
		v = new boolean[n + 1][m + 1];
		bfs(sx, sy);
		
		if (answer == 0) {
			System.out.println("TT");
		}else {
			System.out.println(answer);			
		}
	}
	
	static void bfs(int sx, int sy) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(sx, sy));
		v[sx][sy] = true;
		
		while(!q.isEmpty()) {
			Point c = q.remove();
			
			for(int d = 0; d < 4; d++) {
				int nx = c.x + dx[d];
				int ny = c.y + dy[d];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && !v[nx][ny] && school[nx][ny] != 'X') {
					v[nx][ny] = true;
					q.add(new Point(nx, ny));
					if (school[nx][ny] == 'P') {
						answer++;
					}
				}
			}
		}
	}
}

class Point{
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
