import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());

			String row = br.readLine();
			row = row.substring(1, row.length() - 1);
			Deque<Integer> dq = new ArrayDeque<>();

			if (n == 0) {
				if (p.contains("D")) System.out.println("error");
				else System.out.println("[]");
				continue;
			}


			String[] nums = row.split(",");
			
			for (int i = 0; i < n; i++) {
				dq.offer(Integer.parseInt(nums[i]));
			}
			
			boolean reverse = false;
			boolean error = false;
			
			for (int i = 0; i < p.length(); i++) {
				char command = p.charAt(i);
				switch (command) {
					case 'R': {
						reverse = !reverse;
						break;
					} 
					case 'D': {
						if (dq.isEmpty()) error = true;
						if (!reverse) dq.pollFirst();
						else dq.pollLast();
						break;
					}
				}
			}
			
			if (error) System.out.println("error");
			else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				
				if (!reverse) {
					while (!dq.isEmpty()) sb.append(dq.pollFirst()).append(",");
				} else {
					while (!dq.isEmpty()) sb.append(dq.pollLast()).append(",");
				}
				
				if (sb.length() > 1) sb.deleteCharAt(sb.length() - 1);
				sb.append("]");
				System.out.println(sb);
			}
		}
	}
}
