import java.io.*;
import java.util.*;

public class Main {
	static int len = 1;
	static int[] minTree, maxTree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		while (len < n) len <<= 1;
		
		minTree = new int[2 * len];
		maxTree = new int[2 * len];
		
		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(br.readLine());
			minTree[i + len] = val;
			maxTree[i + len] = val;
		}
		
		for (int i = n; i < len; i++) {
			minTree[i + len] = Integer.MAX_VALUE;
		}
		
		for (int i = len - 1; i > 0; i--) {
			minTree[i] = Math.min(minTree[2 * i], minTree[2 * i + 1]);
			maxTree[i] = Math.max(maxTree[2 * i], maxTree[2 * i + 1]);			
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(get(1, 0, len - 1, a - 1, b - 1, minTree, true) + " " + get(1, 0, len - 1, a - 1, b - 1, maxTree, false));
		}
	}
	
	static int get(int idx, int s, int e, int ts, int te, int[] tree, boolean isMin) {
		if (s > te || e < ts) {
			if (isMin) return Integer.MAX_VALUE;
			else return 0;
		}
		else if (ts <= s && e <= te) return tree[idx];
		
		int mid = (s + e) / 2;
		
		int l = get(2 * idx, s, mid, ts, te, tree, isMin);
		int r = get(2 * idx + 1, mid + 1, e, ts, te, tree, isMin);
		
		if (isMin) return Math.min(l, r);
		else return Math.max(l, r);
	}
}
