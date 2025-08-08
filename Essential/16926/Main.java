import java.io.*;
import java.util.*;

public class Main {	
	static int n, m;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];

		for(int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		for (int i = 0; i < r; i++) {
			rotateArr(arr);
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void rotateArr(int[][] arr){
		for (int idx = 0; idx < Math.min(n, m) / 2; idx++) {
			int top = idx;
			int left = idx;
			int bottom = n - idx - 1;
			int right = m - idx - 1;

			int temp = arr[top][left];

			for (int j = left; j < right; j++) {
				arr[top][j] = arr[top][j + 1];
			}
			for (int i = top; i < bottom; i++) {
				arr[i][right] = arr[i + 1][right];
			}
			for (int j = right; j > left; j--) {
				arr[bottom][j] = arr[bottom][j - 1];
			}
			for (int i = bottom; i > top + 1; i--) {
				arr[i][left] = arr[i - 1][left];
			}
			arr[top + 1][left] = temp;

		}
		return;
	}

}
