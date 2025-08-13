import java.io.*;

public class Main {
	static int n, answer;
	static boolean[] col, slash, bSlash;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		col = new boolean[n + 1];
		slash = new boolean[2 * n + 1];
		bSlash = new boolean[2 * n];
		
		answer = 0;
		setQueen(1);
		System.out.println(answer);
		
	}
	
	static void setQueen(int row) {
		
		if(row > n) {
			++answer;
			return;
		}
		
		for (int c = 1; c <= n; c++) {
			if (col[c] || slash[row + c] || bSlash[row - c + n]) {
				continue;
			}
			
			col[c] = slash[row + c] = bSlash[row - c + n] = true;
			setQueen(row + 1);
			col[c] = slash[row + c] = bSlash[row - c + n] = false;
		}
	}
}
