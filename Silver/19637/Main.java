import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] name = new String[n];
		int[] value = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			name[i] = st.nextToken();
			value[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			int force = Integer.parseInt(br.readLine());
			int idx = lowerBound(value, force);

			System.out.println(name[idx]);
		}
	}

	static int lowerBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length - 1;
		int ans = arr.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (arr[mid] >= key) {
				ans = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}

		return ans;
	}
}
