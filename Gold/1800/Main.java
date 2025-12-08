import java.io.*;
import java.util.*;

public class Main2 {
    static int V, E, k;
    static List<List<Node>> adj = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Node(v, w));
            adj.get(v).add(new Node(u, w));
        }

        int left = 0;
        int right = 1000000;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (dijkstra(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean dijkstra(int limit) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cnt = cur[1];

            if (cnt > dist[node]) continue;

            for (Node next : adj.get(node)) {
                int nextCnt = cnt;
                if (next.w > limit) nextCnt++;

                if (nextCnt < dist[next.to] && nextCnt <= k) {
                    dist[next.to] = nextCnt;
                    pq.offer(new int[]{next.to, nextCnt});
                }
            }
        }

        return dist[V] != Integer.MAX_VALUE;
    }

}

class Node {
    int to, w;
    Node(int to, int w){
        this.to = to;
        this.w = w;
    }
}
