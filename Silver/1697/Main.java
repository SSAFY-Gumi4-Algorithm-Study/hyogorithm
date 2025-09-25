import java.io.*;
import java.util.*;

public class Main {
	static int n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		System.out.println(bfs());
	}

	static int bfs() {
		int[] dist = new int[100001];
		Arrays.fill(dist, -1);

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n);
		dist[n] = 0;

		while (!q.isEmpty()) {
			int c = q.poll();

			if (c == k) return dist[c];

			int[] nexts = {c * 2, c + 1, c - 1};

			for(int next : nexts) {
				if (next >= 0 && next <= 100000 && dist[next] == -1) {
					dist[next] = dist[c] + 1;
					q.offer(next);
				}
			}

		}

		return -1;
	}
}
