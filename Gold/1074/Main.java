import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		System.out.println(z(r, c, 1 << n));
	}

	static int z(int r, int c, int size) {
		if (size == 1) return 0;
		int half = size / 2;
		int block = half * half;
		
		int quad = 0;
		if (r >= half) {
			quad += 2;
			r -= half;
		}
		if (c >= half) {
			quad += 1;
			c -= half;
		}
		
		return quad * block + z(r, c, half);
	}
}
