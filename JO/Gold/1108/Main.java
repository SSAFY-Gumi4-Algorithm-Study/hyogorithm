import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static List<List<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 500; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj.get(s).add(e);
            V = Math.max(V, Math.max(s, e));
        }

        int total = 0;
        for (int i = 1; i <= V; i++) {
            total += bfs(i);
        }

        double answer = (double) total / (V * (V - 1));
        System.out.printf("%.3f\n", answer);
    }

    static int bfs(int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int c = q.poll();
            for (int next : adj.get(c)) {
                if (dist[next] == -1) {
                    dist[next] = dist[c] + 1;
                    q.offer(next);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= V; i++) {
            if (i == start) continue;
            sum += dist[i];
        }

        return sum;
    }
}
