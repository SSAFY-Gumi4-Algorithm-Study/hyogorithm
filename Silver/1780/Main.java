import java.io.*;
import java.util.*;

public class Main {
	static int n, zero, plus, minus;
	static int[][] paper;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		paper = new int[n][n];
		zero = 0;
		plus = 0;
		minus = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0, 0, n);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);		
	}

	static void cut(int r, int c, int size) {
		boolean flag = true;
		int first = paper[r][c];
		
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (paper[i][j] != first) flag = false;
			}
		}
		
		if (flag && first == 1) plus++;
		else if (flag && first == 0) zero++;
		else if (flag && first == -1) minus++;
		else {
			int newSize = size/3;
			cut(r, c, newSize);
			cut(r, c + newSize, newSize);
			cut(r, c + newSize * 2, newSize);
			cut(r + newSize, c, newSize);
			cut(r + newSize, c + newSize, newSize);
			cut(r + newSize, c + newSize * 2, newSize);
			cut(r + newSize * 2, c, newSize);
			cut(r + newSize * 2, c + newSize, newSize);
			cut(r + newSize * 2, c + newSize*2, newSize);
		}
	}
}
