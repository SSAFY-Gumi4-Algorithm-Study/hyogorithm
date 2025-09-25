import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[] sort = Arrays.copyOf(nums, n);
		Arrays.sort(sort);
		
		HashMap<Integer, Integer> rank = new HashMap<>(n * 2);
        int idx = 0;
        for (int v : sort) {
            if (!rank.containsKey(v)) rank.put(v, idx++);
        }

        for (int v : nums) {
            sb.append(rank.get(v)).append(' ');
        }
        
		System.out.println(sb);
	}
}
