import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] ropes = new int[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        int max = 0;
        for (int i = 0; i < n; i++) {
            int w = ropes[i] * (n - i);
            max = Math.max(max, w);
        }

        System.out.println(max);
    }
}
