import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long result = 1;
        a %= c;

        while (b > 0) {
            if (b % 2 == 1) result = (result * a) % c;
            a = a * a % c;
            b /= 2;
        }
        System.out.println(result);
    }
}
