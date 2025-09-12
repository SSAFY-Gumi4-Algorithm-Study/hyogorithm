import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] im = new int[k];
		int[] t = new int[k];
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			im[i] = Integer.parseInt(st.nextToken());
			t[i] = Integer.parseInt(st.nextToken());
		}
 
		int[] dp = new int[n + 1];
		for (int i = 0; i < k; i++) {
			for (int j = n; j >= t[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - t[i]] + im[i]);
			}
		}
		
		System.out.println(dp[n]);
	}	
}
