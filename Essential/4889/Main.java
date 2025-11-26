import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		while (true) {
			String str = br.readLine();
			if (str.charAt(0) == '-') break;
			tc++;
			
			Stack<Character> stack = new Stack<>();
			int answer = 0;
			
			for (int i = 0; i < str.length(); i++) {				
				if (str.charAt(i) == '{') stack.push('{');
				else {
					if (stack.isEmpty()) {
                        answer++;
                        stack.push('{');
                    } else {
                        stack.pop();
                    }
				}
			}
			answer += stack.size() / 2;
			
			System.out.println(tc + ". " + answer);
		}
	}
}
