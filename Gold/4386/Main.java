import java.io.*;
import java.util.*;

public class Main {
	static double[][] cost;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = n * (n - 1) / 2;

		cost = new double[m][3];	
		Point[] points = new Point[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			points[i] = new Point(x, y);
		}

		int index = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            cost[index][0] = i;
            cost[index][1] = j;
            cost[index][2] = getdistance(points[i].x, points[i].y, points[j].x, points[j].y);
            index++;
        }
    }

		Arrays.sort(cost, (a, b) -> Double.compare(a[2], b[2]));
		parent = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		double sum = 0;
		for (int i = 0; i < m; i++) {
			if (find((int)cost[i][0]) != find((int)cost[i][1])) {
				union((int)cost[i][0], (int)cost[i][1]);
				sum += cost[i][2];
			}
		}
		System.out.println(sum);
	}
	
	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb) return false;
		
		if (pa < pb) parent[pb] = pa;
		else parent[pa] = pb;
		return true;
	}
	
	static double getdistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
}

class Point {
	double x, y;

	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
