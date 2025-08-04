import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] size = new int[6];
        
        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st2.nextToken());
        int p = Integer.parseInt(st2.nextToken());
        int tOrder = 0;
        
        for (int s : size) {
				    tOrder += (s + t - 1) / t;
				}
        System.out.println(tOrder);
        System.out.println((n / p) + " " + (n % p));
        br.close();
    }
}