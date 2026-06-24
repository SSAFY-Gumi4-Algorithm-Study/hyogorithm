import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] ugly = new long[1501];

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);

        int idx = 1;
        long prev = 0;
        while (idx <= 1500) {
            long cur = pq.poll();

            if (cur == prev) continue;

            ugly[idx++] = cur;
            prev = cur;
            pq.offer(cur * 2);
            pq.offer(cur * 3);
            pq.offer(cur * 5);
        }

        while (true) {
            int n = Integer.parseInt(br.readLine().trim());
            if (n == 0) break;
            sb.append(ugly[n]).append('\n');
        }

        System.out.print(sb);
    }
}
