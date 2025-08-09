import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		int[] acgt = new int[4];
		for(int i = 0; i < p; i++) {
			acgt[toIdx(str.charAt(i))]++;
		}
		
		if(acgt[0] >= a && acgt[1] >= c && acgt[2] >= g && acgt[3] >= t) {
			answer++;
		}
		
		for (int i = p; i < s; i++) {
			acgt[toIdx(str.charAt(i))]++;
			acgt[toIdx(str.charAt(i - p))]--;
			if(acgt[0] >= a && acgt[1] >= c && acgt[2] >= g && acgt[3] >= t) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	static int toIdx(char ch) {
        switch (ch) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            default:  return 3;
        }
    }
}
