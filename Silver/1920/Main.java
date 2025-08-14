import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] a, x;
	static Set<Integer> tops = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		
		m = Integer.parseInt(br.readLine());
		x = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			if(binarySearch(a, 0, n - 1, x[i])) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}		
	}
	
	static boolean binarySearch(int[] a, int start, int end, int x) {
		if (start > end) {
			return false;
		}
		else {
			int mid = (start + end) / 2;
			if(a[mid] == x) {
				return true;
			} else if (a[mid] < x) {
				return binarySearch(a, mid + 1, end, x);
			} else {
				return binarySearch(a, start, mid - 1, x);
			}
		}
	}
}
