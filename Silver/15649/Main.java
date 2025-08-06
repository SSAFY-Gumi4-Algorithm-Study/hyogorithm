import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	boolean[] v = new boolean[n];
        List<Integer> path = new ArrayList<>();

    	dfs(path, v);
    }
    
    static void dfs(List<Integer> path, boolean[] v) {
    	if(path.size() == m) {
    		for(int num : path) {
    			System.out.print(num + " ");
    		}
    		System.out.println();
    		return;
    	}
    	
    	for(int i = 0; i < n; i++) {
    		if(!v[i]) {
    			v[i] = true;
    			path.add(i+1);
    			dfs(path, v);
    			path.remove(path.size()-1);
    			v[i] = false;
    		}
    	}
    }
}
