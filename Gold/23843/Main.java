import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[] electronics = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            electronics[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(electronics, Collections.reverseOrder());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int time = 0;
        for (int i = 0; i < n; i++) {
            if (pq.size() >= m) time = pq.poll();
            pq.add(time + electronics[i]);
        }

        while (!pq.isEmpty()) {
            time = pq.poll();
        }

        System.out.println(time);
    }
}
