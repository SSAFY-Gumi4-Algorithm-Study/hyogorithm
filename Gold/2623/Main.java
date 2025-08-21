import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static ArrayList<Integer>[] graph;
	static int[] inD;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		inD = new int[n + 1];

		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int k  = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			for (int j = 1; j < k; j++) {
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				inD[b]++;
				a = b;
			}
		}

		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= n; i++) {
			if(inD[i] == 0) {
				q.offer(i);
			}
		}

		ArrayList<Integer> result = new ArrayList<>();

		while(!q.isEmpty()) {
			int node = q.poll();
			result.add(node);

			for(int i : graph[node]) {
				inD[i]--;
				if(inD[i] == 0) {
					q.offer(i);
				}
			}
		}
		
		if (result.size() != n) {
			System.out.println(0);
		} else {
			for(int r : result) {
				System.out.println(r);
			}			
		}
	}
}
