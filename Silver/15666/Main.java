import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] nums;
	static Set<List<Integer>> ans = new LinkedHashSet<>(); 

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

		dfs(new ArrayList<>(), 0);
		for (List<Integer> list : ans) {
			for (int x : list) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	static void dfs(List<Integer> path, int s) {
		if(path.size() == m) {
			ans.add(new ArrayList<>(path));
			return;
		}

		for(int i = s; i < n; i++) {
			path.add(nums[i]);
			dfs(path, i);
			path.remove(path.size() - 1);
		}
	}
}
