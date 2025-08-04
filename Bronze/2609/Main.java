import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int gcd = gcd(n1, n2);
        System.out.println(gcd);
        System.out.println((n1 * n2) / gcd);
        br.close();
    }
    
    static int gcd(int a, int b) {
        return (a % b != 0) ? gcd(b, a % b) : b;
    }
}
