import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<Point> gold = new ArrayList<>();
		Set<Integer> xSet = new HashSet<>();
		Set<Integer> ySet = new HashSet<>();
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			gold.add(new Point(a, b));
			xSet.add(a);
			ySet.add(b);
            xSet.add(Math.max(0, a - k));
            ySet.add(Math.max(0, b - k));
		}
		
		List<Integer> xList = new ArrayList<>(xSet);
		List<Integer> yList = new ArrayList<>(ySet);
		
		Collections.sort(xList);
		Collections.sort(yList);
		
		int max = -1;
		int left = 0;
		int top = 0;
		
		for (int x : xList) {
            if (x < 0 || x > n) continue;
            if (x + k > n) continue;
            for (int y : yList) {
                if (y < 0 || y > m) continue;
                if (y + k > m) continue;

                int cnt = 0;
                for (Point p : gold) {
                    if (x <= p.x && p.x <= x + k && y <= p.y && p.y <= y + k) {
                        cnt++;
                    }
                }

                if (cnt > max) {
                    max = cnt;
                    left = x;
                    top = y + k;
                }
            }
        }
		System.out.println(left + " " + top);
		System.out.println(max);
	}
}

class Point {
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
