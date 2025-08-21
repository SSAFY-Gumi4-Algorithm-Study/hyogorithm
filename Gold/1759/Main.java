import java.io.*;
import java.util.*;

public class Main {
	static int l, c;
	static String[] alpa;
  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		alpa = new String[c];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < c; i++) {
			alpa[i] = st.nextToken();
		}
		Arrays.sort(alpa);
		
		bt(new ArrayList<>(), 0);	
	}
	static void bt(List<String> path, int s) {
		if(path.size() == l) {
			if(check(path)) {
				for (String a : path) {
					System.out.print(a);
				}
				System.out.println();
			}
			
			return;
		}
		
		for (int i = s; i < c; i++) {
			path.add(alpa[i]);
			bt(path, i + 1);
			path.remove(path.size() - 1);
		}
	}
	
	static boolean check(List<String> path) {
		String vowels = "aeiou";
		int cCnt = 0;
		int vCnt = 0;
		
		for (String s : path) {
			if (vowels.indexOf(s) != -1) {
				vCnt++;
			} else {
				cCnt++;
			}
			
			if (cCnt >= 2 && vCnt >= 1) return true;
		}
		return false;
	}
}
