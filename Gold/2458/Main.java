import java.io.*;
import java.util.*;

public class Main {
	static int n, sCnt, tCnt, answer;
	static List<List<Integer>> smaller = new ArrayList<>();
	static List<List<Integer>> taller = new ArrayList<>();
	static boolean[] vS, vT;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= n; i++) {
			smaller.add(new ArrayList<>());
			taller.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			taller.get(s).add(t);
			smaller.get(t).add(s);
		}
		
		for (int i = 1; i <= n; i++) {
			sCnt = 0;
			tCnt = 0;
			vS = new boolean[n + 1];
			vT = new boolean[n + 1];
			
			dfsS(i);
			dfsT(i);
			
			if (sCnt + tCnt == n - 1) {
				answer++;
			}
		}
		
		System.out.println(answer);		
	}
	
	static void dfsS(int idx) {
		vS[idx] = true;
		
		for (int s : smaller.get(idx)) {
			if (!vS[s]) {
				sCnt++;
				dfsS(s);				
			}
		}
    }
	
	static void dfsT(int idx) {
		vT[idx] = true;
		
		for (int t : taller.get(idx)) {
			if (!vT[t]) {
				tCnt++;
				dfsT(t);				
			}
		}
    }
}
