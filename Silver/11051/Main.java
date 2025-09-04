import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		System.out.println(bino(n, k));
	}
	
	static int bino(int n, int k) {
		int[][] b = new int[n + 1][n + 1];
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || j == i) b[i][j] = 1;
				else b[i][j] = (b[i - 1][j - 1] + b[i - 1][j]) % 10007;
			}
		}
		return b[n][k];
	}
}
