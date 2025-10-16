import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] nums;
	static boolean[] v;
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

		v = new boolean[n];
		dfs(new ArrayList<>());
		for (List<Integer> list : ans) {
            for (int x : list) {
            	System.out.print(x + " ");
            }
            System.out.println();
        }
	}

	static void dfs(List<Integer> path) {
		if(path.size() == m) {
			ans.add(new ArrayList<>(path));
			return;
		}

		for(int i = 0; i < n; i++) {
			if (!v[i]) {
				path.add(nums[i]);
				v[i] = true;
				dfs(path);
				path.remove(path.size() - 1);
				v[i] = false;
			}
		}
	}
}
