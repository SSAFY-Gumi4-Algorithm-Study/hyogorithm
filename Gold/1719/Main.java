import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static List<List<Node>> adj = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

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

        int[][] result = new int[V + 1][V + 1];
        for (int start = 1; start <= V; start++) {
            int[] prev = new int[V + 1];
            int[] dist = dijkstra(start, prev);

            for (int dest = 1; dest <= V; dest++) {
                if (start == dest) {
                    result[start][dest] = 0;
                } else if (dist[dest] == Integer.MAX_VALUE) {
                    result[start][dest] = 0;
                } else {
                    int cur = dest;
                    while (prev[cur] != start) {
                        cur = prev[cur];
                    }
                    result[start][dest] = cur;
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (result[i][j] == 0) {
                    sb.append("- ");
                } else {
                    sb.append(result[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int[] dijkstra(int start, int[] prev) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, 0);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node c = pq.poll();

            if (c.w > dist[c.to]) continue;

            for (Node v : adj.get(c.to)) {
                int newWeight = c.w + v.w;
                if (newWeight < dist[v.to]) {
                    dist[v.to] = newWeight;
                    prev[v.to] = c.to;
                    pq.offer(new Node(v.to, newWeight));
                }
            }
        }

        return dist;
    }

}

class Node {
    int to, w;
    Node(int to, int w){
        this.to = to;
        this.w = w;
    }
}
