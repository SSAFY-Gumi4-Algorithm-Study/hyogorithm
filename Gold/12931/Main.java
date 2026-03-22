import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader((System.in))));
        int n = Integer.parseInt(br.readLine());

        int[] b = new int[n];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            sum += b[i];
        }

        int count = 0;
        while (sum != 0) {
            int odd = 0;
            for (int i = 0; i < n; i++) {
                if (b[i] % 2 == 1) {
                    b[i]--;
                    odd++;
                }
            }

            if (odd != 0) {
                sum -= odd;
                count += odd;
                continue;
            }

            for (int i = 0; i < n; i++) {
                b[i] /= 2;
            }
            sum /= 2;
            count++;
        }

        System.out.print(count);
    }
}
