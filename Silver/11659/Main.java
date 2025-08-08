import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] nums;
	static boolean flag;
	static List<Integer> answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[n];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st2.nextToken());				
		}
		
		int[] prefix = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			prefix[i] = prefix[i-1] + nums[i-1];		
		}
		
		for(int idx = 0; idx < m; idx++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st3.nextToken());
			int j = Integer.parseInt(st3.nextToken());
			
			System.out.println(prefix[j] - prefix[i-1]);
		}
	}
}
