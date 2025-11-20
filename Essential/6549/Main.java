import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			if (n == 0) break;
			
			long[] height = new long[n];
			for (int i = 0; i < n; i++) height[i] = Long.parseLong(st.nextToken());
			
			Deque<Integer> stack = new ArrayDeque<Integer>();
			long max = 0;
			
            for (int i = 0; i <= n; i++) {
            	long c = (i == n) ? 0 : height[i];

                while (!stack.isEmpty() && height[stack.peek()] > c) {
                    long h = height[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = Math.max(max, h * w);
                }
                stack.push(i);
            }
            
			System.out.println(max);
		}
	}
}
