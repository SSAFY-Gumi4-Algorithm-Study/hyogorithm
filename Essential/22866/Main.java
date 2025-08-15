import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] h = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] count = new int[n + 1];
		int[] building = new int[n + 1];
		Arrays.fill(building, Integer.MAX_VALUE);
		Stack<Integer> s = new Stack<>();
		
		for (int i = 1; i <= n; i++) {
			while (!s.isEmpty() && h[s.peek()] <= h[i]) {
				s.pop();
			}
			count[i] += s.size();
			
			if(!s.isEmpty()) {
				building[i] = s.peek();
			}
			s.push(i);
		}
		
		s.clear();
		for (int i = n; i >= 1; i--) {
			while (!s.isEmpty() && h[s.peek()] <= h[i]) {
				s.pop();
			}
			count[i] += s.size();
			
			if(!s.isEmpty()) {
				if(building[i] == 0 || Math.abs(i - building[i]) > Math.abs(i - s.peek())) {
					building[i] = s.peek();
				}
			}
			s.push(i);
		}
		
		for (int i = 1; i <= n; i++) {
			if (count[i] == 0) {
				System.out.println(0);
			} else {
				System.out.println(count[i] + " " + building[i]);
			}
		}
	}
}
