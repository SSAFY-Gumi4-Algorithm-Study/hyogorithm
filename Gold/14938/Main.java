import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<Node>[] adj;
    static int[] itemCnt;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader((System.in))));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();


        itemCnt = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            itemCnt[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, l));
            adj[b].add(new Node(a, l));
        }

        int ans = 0;
        v = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dijkstra(i));
        }

        System.out.println(ans);
    }

    static int dijkstra(int node) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(v, false);
        dist[node] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));

        pq.offer(new Node(node, 0));

        while (!pq.isEmpty()) {
            Node c = pq.poll();
            v[c.to] = true;
            for (Node next : adj[c.to]) {
                int newDist = c.w + next.w;
                if (!v[next.to] && dist[next.to] >= newDist) {
                    pq.offer(new Node(next.to, newDist));
                    dist[next.to] = newDist;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) cnt += itemCnt[i];
        }
        return cnt;
    }
}

class Node {
    int to, w;
    Node(int to, int w) {
        this.to = to;
        this.w = w;
    }
}
