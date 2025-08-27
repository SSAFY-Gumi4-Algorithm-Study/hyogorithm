import java.io.*;
import java.util.*;

public class Main {
	static int[][] grid;
	static int w, b;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, n);
		System.out.println(w);
		System.out.println(b);
	}
	static void divide(int r, int c, int size) {
		int sum = 0;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				 sum += grid[i][j];
			}
		}
		
		if (sum == size * size) b++;
		else if (sum == 0) w++;
		else {
			int newSize = size / 2;
			divide(r, c, newSize);
			divide(r, c + newSize, newSize);
			divide(r + newSize, c, newSize);
			divide(r + newSize, c + newSize, newSize);
		}
	}
}
