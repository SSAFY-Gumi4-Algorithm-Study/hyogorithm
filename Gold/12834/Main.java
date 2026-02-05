import java.io.*;
import java.util.*;

public class Main {
    static int N, V, E;
    static List<List<Node>> adj = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Node(v, t));
            adj.get(v).add(new Node(u, t));
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int[] result = dijkstra(houses[i]);
          
            if (result[a] == Integer.MAX_VALUE) result[a] = -1;
            if (result[b] == Integer.MAX_VALUE) result[b] = -1;
          
            answer += result[a] + result[b];
        }

        System.out.println(answer);
    }

    static int[] dijkstra(int house) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[house] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
        pq.offer(new Node(house, 0));

        while (!pq.isEmpty()) {
            Node c = pq.poll();

            if (c.w > dist[c.to]) continue;

            for (Node v : adj.get(c.to)) {
                int newWeight = c.w + v.w;
                if (newWeight < dist[v.to]) {
                    dist[v.to] = newWeight;
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
