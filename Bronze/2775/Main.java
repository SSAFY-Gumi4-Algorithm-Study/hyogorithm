import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int k = Integer.parseInt(br.readLine());	
			int n = Integer.parseInt(br.readLine());	
			
			int[][] apt = new int[k + 1][n + 1];
			for (int i = 0; i <= n; i++) {
				apt[0][i] = i;
			}
			
			for (int i = 1; i <= k; i++) {
				int sum = 0;
				for (int j = 1; j <= n; j++) {
					sum += apt[i - 1][j];
					apt[i][j] = sum;
				}
			}
			
			System.out.println(apt[k][n]);
		}
	}
}
