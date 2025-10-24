import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] sensor = new int[n];
		for (int i = 0; i < n; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sensor);

		int[] diff = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			diff[i] = sensor[i + 1] - sensor[i];
		}
		Arrays.sort(diff);

		int answer = 0;
		if (k < n) {
			for (int i = 0; i < n - k; i++) {
				answer += diff[i];
			}
		}
		
		System.out.println(answer);
	}
}
