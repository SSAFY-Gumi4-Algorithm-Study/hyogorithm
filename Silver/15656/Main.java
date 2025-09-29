import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());			
		}
		Arrays.sort(nums);

		dfs(new ArrayList<>());
		System.out.println(sb);
	}

	static void dfs(List<Integer> path) {
		if(path.size() == m) {
			for(int i = 0; i < m; i++) {
				sb.append(path.get(i)).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i = 0; i < n; i++) {
			path.add(nums[i]);
			dfs(path);
			path.remove(path.size() - 1);
		}
	}
}
