import java.io.*;
import java.util.*;

public class Main {
    static int len = 1;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        while (len < n) len <<= 1;

        tree = new long[2 * len];

        for (int i = 0; i < n; i++) {
            tree[i + len] = Long.parseLong(br.readLine());
        }

        for (int i = n; i < len; i++) {
            tree[i + len] = 1;
        }

        for (int i = len - 1; i > 0; i--) {
            tree[i] = tree[2 * i] * tree[2 * i + 1] % 1000000007;
        }
        
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) update(b - 1, c);
            else if (a == 2) System.out.println(get(1, 0, len - 1, b - 1, c - 1));
        }
    }

    static void update(int idx, long val) {
        idx += len;
        tree[idx] = val;
        idx /= 2;

        while (idx >= 1) {
            tree[idx] = tree[2 * idx] * tree[2 * idx + 1] % 1000000007;
            idx /= 2;
        }
    }

    static long get(int idx, long s, long e, long ts, long te) {
        if (s > te || e < ts) return 1;
        else if (ts <= s && e <= te) return tree[idx];

        long mid = (s + e) / 2;

        long l = get(2 * idx, s, mid, ts, te);
        long r = get(2 * idx + 1, mid + 1, e, ts, te);

        return l * r % 1000000007;
    }
}
