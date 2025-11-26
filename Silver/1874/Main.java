import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		int start = 0;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > start) {
				for (int j = start + 1; j <= num; j++) {
					stack.push(j);
					sb.append("+").append("\n");
				}
				start = num;
			} else if (stack.peek() != num) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append("-").append("\n");
		}
		System.out.println(sb);
	}
}
