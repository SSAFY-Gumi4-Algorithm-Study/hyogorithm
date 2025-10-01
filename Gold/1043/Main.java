import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Set<Integer> know = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			know.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer>[] party = new ArrayList[m];
		for (int i = 0; i < m; i++) {
			party[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
        boolean changed;
        do {
        	changed = false;
        	for (List<Integer> p : party) {
        		Set<Integer> temp = new HashSet<>(know);
        		boolean flag = false;
        		for (int t : temp) {
        			if (p.contains(t)) {
        				flag = true;
        				break;
        			}
        		}
        		
        		if (flag) {
        			if(know.addAll(p)) changed = true;
        		}
        	}
        } while (changed);

		int ans = 0;
		for (List<Integer> p : party) {
			boolean flag = false;

			for (int k : know) {
				if (p.contains(k)) {
					flag = true;
					break;
				}
			}
			if (!flag) ans++;
		}		
		
		System.out.println(ans);
	}
}
