import java.io.*;
import java.util.*;

public class Main {
	static int n, m, answer;
	static int[][] room;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken()); // 0북 1동 2남 3서
		
		room = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(r, c, d);
		System.out.println(answer);
	}
	
	static void clean(int r, int c, int d) {
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		if (room[r][c] == 0) { // 0 청소전 1 벽 2 청소완
			room[r][c] = 2; // 현재칸 청소하기
			answer++;
		}
		
		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4; // 반시계 90도
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr >= 0 && nr < n && nc >= 0 && nc < m && room[nr][nc] == 0) {
				clean(nr, nc, d);
				return;
			}
		}
		
		int nr = r + dr[(d + 2) % 4]; // 후진
		int nc = c + dc[(d + 2) % 4];
		
		if (nr >= 0 && nr < n && nc >= 0 && nc < m && room[nr][nc] != 1) {
			clean(nr, nc, d);
		}
		
	}
}
