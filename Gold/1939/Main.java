import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
    }

    static int dijkstra(int s, int e) {
        int[] dist = new int[n + 1];
        dist[s] = Integer.MAX_VALUE;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.w - o1.w);
        pq.offer(new Node(s, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            Node c = pq.poll();

            if (c.to == e) return c.w;
            if (c.w < dist[c.to]) continue;

            for (Node next : graph[c.to]) {
                int newWeight = Math.min(c.w, next.w);

                if (newWeight > dist[next.to]) {
                    dist[next.to] = newWeight;
                    pq.offer(new Node(next.to, newWeight));
                }
            }
        }

        return 0;
    }
}

class Node {
    int to, w;
    Node(int to, int w){
        this.to = to;
        this.w = w;
    }
}
