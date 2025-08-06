import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	Set<String> noHear = new HashSet<>();
    	for(int i = 0; i < n; i++) {
    		noHear.add( br.readLine());
    	}

    	List<String> result = new ArrayList<>();
    	for(int i = 0; i < m; i++) {
    		String name = br.readLine();
    		if(noHear.contains(name)) {
    			result.add(name);
    		}
    	}

    	Collections.sort(result);
    	
    	System.out.println(result.size());
    	for (String name : result) {
            System.out.println(name);
        }
    }
}
