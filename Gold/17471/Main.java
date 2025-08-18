import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] population;
	static List<Set<Integer>> adj;
	static boolean[] inA;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		population = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		adj = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			adj.add(new HashSet<>());
		}
		
		for(int s = 1; s <= n; s++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int i = 0; i < cnt; i++) {
				int e = Integer.parseInt(st.nextToken());
				adj.get(s).add(e);
				adj.get(e).add(s);
				
			}
		}
		
		inA = new boolean[n + 1];
		
		for (int k = 1; k < n; k++) {
            comb(1, 0, k);
        }

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);			
		}
	}
	
	static void comb(int idx, int chosen, int k) {
        if (chosen + (n - idx + 1) < k) return;

        if (chosen == k) {
            if (isConnected(true) && isConnected(false)) {
                int sumA = 0, sumB = 0;
                for (int i = 1; i <= n; i++) {
                    if (inA[i]) sumA += population[i];
                    else sumB += population[i];
                }
                answer = Math.min(answer, Math.abs(sumA - sumB));
            }
            return;
        }
        if (idx > n) return;

        inA[idx] = true;
        comb(idx + 1, chosen + 1, k);

        inA[idx] = false;
        comb(idx + 1, chosen, k);
    }
	
	static boolean isConnected(boolean groupA) {
        int start = -1, size = 0;
        for (int i = 1; i <= n; i++) {
            boolean inGroup = groupA ? inA[i] : !inA[i];
            if (inGroup) {
                size++;
                if (start == -1) start = i;
            }
        }
        if (size == 0) return false;

        boolean[] v = new boolean[n + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        v[start] = true;
        int visited = 1;

        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int nxt : adj.get(cur)) {
                boolean inGroup = groupA ? inA[nxt] : !inA[nxt];
                if (inGroup && !v[nxt]) {
                    v[nxt] = true;
                    visited++;
                    q.add(nxt);
                }
            }
        }
        return visited == size;
    }
}
