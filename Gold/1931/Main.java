import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] time = new int[n][2];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, new Comparator<int[]>() {
			public int compare(int[] t1, int[] t2) {
				if(t1[1] == t2[1]) {
					return t1[0] - t2[0];
				}
				return t1[1] - t2[1];
			}
		});
		
		int count = 1;
		int endTime = time[0][1];

		for (int i = 1; i < n; i++) {
		    if (time[i][0] >= endTime) {
		        count++;
		        endTime = time[i][1];
		    }
		}

		System.out.println(count);
	}
}
