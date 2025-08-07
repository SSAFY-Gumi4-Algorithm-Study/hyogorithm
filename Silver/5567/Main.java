import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static List<List<Integer>> adj;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    	
    	n = Integer.parseInt(br.readLine()); // 동기의 수
    	m = Integer.parseInt(br.readLine()); // 리스트의 길이(친구 관계 수)
    	
    	adj = new ArrayList<>();
    	
    	for (int i = 0; i <= n; i++) {
    	    adj.add(new ArrayList<>());
    	}
    	
    	for(int i = 0; i < m; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		adj.get(s).add(e);
    		adj.get(e).add(s);
    	}
    	
    	boolean[] v = new boolean[n + 1];
    	bfs(1, v);
    	System.out.println(cnt);
    }
    
    static void bfs(int s, boolean[] v) {
    	Queue<int[]> q = new ArrayDeque<>();
    	q.add(new int[] {s, 0});
    	v[s] = true;
    	cnt = 0;
    	
    	while(!q.isEmpty()) {
    		int[] c = q.remove();
    		
    		if(c[1] >= 2) {
    			continue;
    		}
    		for(int n : adj.get(c[0])) {
    			if(!v[n]) {
    				v[n] = true;
    				q.add(new int[] {n, c[1] + 1});
    				cnt++;
    			}
    		}
    	}
    }
}
