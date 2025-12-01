import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] liquid = new int[n];
		for (int i = 0; i < n; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
        Arrays.sort(liquid);

		int l = 0;
		int r = n - 1;
		int min = Integer.MAX_VALUE;
		int bestL = 0;
		int bestR = 0;

		while (l < r) {
			int sum = liquid[l] + liquid[r];
			if (Math.abs(sum) < Math.abs(min)) {
				min = sum;
				bestL = l;
				bestR = r;
			}
			
			if (sum < 0) l++;
			else if (sum > 0) r--;
			else break;
		}

		System.out.println(liquid[bestL] + " " + liquid[bestR]);
	}
}
