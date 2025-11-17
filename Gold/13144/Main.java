import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Set<Integer> set = new HashSet<>();
		long cnt = 0;
		int start = 0;
		
		for (int i = 0; i < n; i++) {
			if (set.contains(nums[i])) {
				for (int j = start; j < i; j++) {
					cnt += (i - j);
					start++;
					if (nums[i] == nums[j]) break;
					set.remove(nums[j]);
				}
			} 
			else set.add(nums[i]);
		}
		
		for (int i = start; i< n; i++) cnt += (n - i);
		
		System.out.println(cnt);
	}
}
