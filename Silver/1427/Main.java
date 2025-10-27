import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String n = br.readLine();

		Integer[] num = new Integer[n.length()];

		for (int i = 0; i < n.length(); i++) {
			num[i] = n.charAt(i) - '0';
		}
		Arrays.sort(num, Collections.reverseOrder());

		for (Integer i : num) {
			sb.append(i);
		}
		System.out.println(sb);
	}
}
