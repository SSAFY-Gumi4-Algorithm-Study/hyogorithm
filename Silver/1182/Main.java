import java.io.*;
import java.util.*;

public class Main {
	static int n, s, answer;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
				
		dfs(0, 0);
		
		if (s == 0) answer--;
		
		System.out.println(answer);
	}
	
	static void dfs(int idx, int sum) {	
		if (idx == n) {
			if(sum == s) {
				answer++;
			}
			return;
		}
		
		dfs(idx + 1, sum + arr[idx]);
		dfs(idx + 1, sum);
	}
}
