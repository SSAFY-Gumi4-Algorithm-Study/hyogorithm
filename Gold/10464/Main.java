import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long s = Long.parseLong(st.nextToken());
            long f = Long.parseLong(st.nextToken());

            long answer = prefix(f) ^ prefix(s - 1);
            System.out.println(answer);
        }
    }

    static long prefix (long n) {
        if (n < 0) return 0;
        switch ((int)(n % 4)) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            default: return 0;
        }
    }
}
