import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[] card = new boolean[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int c = Integer.parseInt(st.nextToken());
			card[c] = true;
		}

		int b = (int) Math.sqrt(n) + 1;
        int[] bucket = new int[n / b + 2];

		for (int i = 1; i <= n; i++) {
			if (card[i]) {
				bucket[(i - 1) / b]++;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int c = Integer.parseInt(st.nextToken());
			int idx = (c - 1) / b;
			
			int select = -1;
			while (idx < n / b + 2) {
				if (bucket[idx] == 0) {
					idx++;
					continue;
				}
				
				for (int j = idx * b + 1; j <= (idx + 1) * b; j++) {
					if (j > c && j <= n && card[j]) {
						card[j] = false;
						bucket[idx]--;
						select = j;
						break;
					}
				}
				
				if (select != -1) break;
				idx++;
			}
			System.out.println(select);
		}
	}
}
