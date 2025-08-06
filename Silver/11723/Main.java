import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int m = Integer.parseInt(br.readLine());
    	Set<Integer> s = new HashSet<>();
    	
    	for(int i = 0; i < m; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	String c = st.nextToken();
        	
        	switch (c) {
				case "all": {
					s.clear();
					for (int j = 1; j <= 20; j++) {
						s.add(j);
					}
					break;
				}
				case "empty": {
					s.clear();
					break;	
				}
				case "add": {
					int x = Integer.parseInt(st.nextToken());
					s.add(x);
					break;	
				}
				case "remove": {
					int x = Integer.parseInt(st.nextToken());
					if (s.contains(x)) {
						s.remove(x);
					}
					break;	
				}
				case "check": {
					int x = Integer.parseInt(st.nextToken());
					sb.append(s.contains(x) ? "1\n" : "0\n");
					break;	
				}
				case "toggle": {
					int x = Integer.parseInt(st.nextToken());
					if (s.contains(x)) {
						s.remove(x);
					}else {
						s.add(x);
					}
				}
        	}  	
    	}
    	System.out.println(sb);
    }
}
