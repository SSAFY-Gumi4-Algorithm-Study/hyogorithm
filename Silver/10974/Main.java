import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		v = new boolean[n + 1];
		
		dfs(new ArrayList<>());
	}
	
	static void dfs(List<Integer> path) {
		if(path.size() == n) {
			for(int i = 0; i < n; i++) {
				System.out.print(path.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if (!v[i]) {
				path.add(i);
				v[i] = true;
				dfs(path);
				path.remove(path.size() - 1);
				v[i] = false;
			}
		}
	}
}
