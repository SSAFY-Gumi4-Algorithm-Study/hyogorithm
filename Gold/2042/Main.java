import java.io.*;
import java.util.*;

public class Main {
	static int len = 1;
	static long[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());

		while (len < n) len <<= 1;
		
		tree = new long[2 * len];
		
		for (int i = 0; i < n; i++) {
			tree[i + len] = Long.parseLong(br.readLine());
		}
		
		for (int i = len - 1; i > 0; i--) {
			tree[i] = tree[2 * i] + tree[2 * i + 1];
		}
		
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) update(b - 1, c);
			else if (a == 2) System.out.println(get(1, 0, len - 1, b - 1, c - 1));
		}
	}
	
	static void update(long idx, long val) {
		idx += len;
		tree[(int) idx] = val;
		idx /= 2;
		
		while (idx >= 1) {
			tree[(int) idx] = tree[(int) (2 * idx)] + tree[(int) (2 * idx + 1)];
			idx /= 2;
		}
	}
	
	static long get(long idx, long s, long e, long ts, long te) {
		if (s > te || e < ts) return 0;
		else if (ts <= s && e <= te) return tree[(int) idx];
		
		long mid = (s + e) / 2;
		
		long l = get(2 * idx, s, mid, ts, te);
		long r = get(2 * idx + 1, mid + 1, e, ts, te);
		
		return l + r;
	}
}
