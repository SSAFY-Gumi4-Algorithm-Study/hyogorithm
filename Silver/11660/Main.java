import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] nums = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				nums[i][j] = Integer.parseInt(st2.nextToken());				
			}				
		}
		
		int[][] prefix = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + nums[i-1][j-1];		
			}
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st3.nextToken());			
			int y1 = Integer.parseInt(st3.nextToken());			
			int x2 = Integer.parseInt(st3.nextToken());			
			int y2 = Integer.parseInt(st3.nextToken());			
			
			System.out.println(prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1]);			
		}
	}
}
