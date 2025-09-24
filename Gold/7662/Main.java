import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int k = Integer.parseInt(br.readLine());
			
			TreeMap<Integer, Integer> map = new TreeMap<>(); // 숫자-개수
			
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String opt = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				
				if ("I".equals(opt)) map.put(n, map.getOrDefault(n, 0) + 1);
				else if (!map.isEmpty()) {
					int key = (n == 1) ? map.lastKey() : map.firstKey();
					
					if (map.get(key) == 1) map.remove(key);
					else map.put(key, map.get(key) - 1);
				}
			}
			
			if (map.isEmpty()) System.out.println("EMPTY");
			else System.out.println(map.lastKey() + " " + map.firstKey());
		}
	} 
}
