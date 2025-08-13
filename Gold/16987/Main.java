import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] eggs;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		eggs = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		bt(0);
		System.out.println(answer);
	}
	
	static void bt(int idx) {
		if(idx == n) {
			int broken = 0;
			for (int i = 0; i < n; i++) {
				if(eggs[i][0] <= 0) {
					broken++;
				}
			}
			answer = Math.max(answer, broken);
			return;
		}
		if(eggs[idx][0] <= 0) {
			bt(idx + 1);
			return;
		}
		
	    boolean attacked = false;

		for (int i = 0; i < n; i++) {
			if (i == idx || eggs[i][0] <= 0) {
				continue;
			}
			
			attacked = true;
			
			eggs[i][0] -= eggs[idx][1];
			eggs[idx][0] -= eggs[i][1];
			bt(idx + 1);
			eggs[i][0] += eggs[idx][1];
			eggs[idx][0] += eggs[i][1];			
		}
		
		if (!attacked) {
	        bt(idx + 1);
	    }
	}
}
