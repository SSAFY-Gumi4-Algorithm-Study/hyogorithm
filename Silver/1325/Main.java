import java.io.*;
import java.util.*;

public class Main {	
	static int n, m;
	static boolean[] v;
	static List<List<Integer>> adj;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	adj = new ArrayList<>();
    	for(int i = 0; i <= n; i++) {
    		adj.add(new ArrayList<>());
    	}
    	for(int i = 0; i < m; i++) {
    		StringTokenizer st2 = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st2.nextToken());
        	int b = Integer.parseInt(st2.nextToken());
    		adj.get(b).add(a);
    	}

    	List<Integer> answers = new ArrayList<>();
    	int maxCnt = -1;
    	for(int i = 1; i <= n; i++) {
    		v = new boolean[n + 1];
    		int cnt = bfs(i);
    		if (cnt > maxCnt) {
    		    maxCnt = cnt;
    		    answers.clear();
    		    answers.add(i);
    		} else if (cnt == maxCnt) {
    		    answers.add(i);
    		}
    	}
    	
    	Collections.sort(answers);
    	for(int i = 0; i < answers.size(); i++) {
    		System.out.print(answers.get(i)+ " ");
    	}
    	
    }
	
	static int bfs(int s) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(s);
		v[s] = true;
		int cnt = 0;
		
		while (!q.isEmpty()) {
			int c = q.remove();
			
			for (int n : adj.get(c)) {
				if(!v[n]) {
					v[n] = true;
					q.add(n);
					cnt++;
				}
			}
		}
		return cnt;
	}
}
