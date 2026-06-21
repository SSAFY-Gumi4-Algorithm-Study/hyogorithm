import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        long answer = 0;
        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();

            long sum = a + b;
            answer += sum;
            pq.offer(sum);
        }

        System.out.println(answer);
    }
}
