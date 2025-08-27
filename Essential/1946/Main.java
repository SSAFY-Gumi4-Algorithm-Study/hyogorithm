import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());

			Person[] person = new Person[n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int doc = Integer.parseInt(st.nextToken());
				int inter = Integer.parseInt(st.nextToken());
				
				person[i] = new Person(doc, inter);
			}
			
			Arrays.sort(person, (p1, p2) -> {
				return p1.document - p2.document;
			});
			
			int result = 1;
			int bestRank = person[0].interview;
			
			for (int i = 0; i < n; i++) {
				if(bestRank > person[i].interview) {
					result++;
					bestRank = person[i].interview;
				}
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}

class Person {
	int document, interview;
	
	Person(int document, int interview){
		this.document = document;
		this.interview = interview;
	}
}
