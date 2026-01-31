import java.io.*;
import java.util.*;

public class Main {
    static List<List<Node>> adj = new ArrayList<>();
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new Node(v, w));
            adj.get(v).add(new Node(u, w));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            v = new boolean[n + 1];

            System.out.println(bfs(start, end));
        }
    }

    static int bfs(int start, int end) {
        Queue<Node> q = new ArrayDeque<>();
        v[start] = true;
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node c = q.poll();

            if (c.to == end) return c.w;

            for (Node nxt : adj.get(c.to)) {
                if (!v[nxt.to]) {
                    v[nxt.to] = true;
                    q.add(new Node(nxt.to, c.w + nxt.w));
                }
            }
        }
        return -1;
    }
}

class Node {
    int to, w;

    Node (int to, int w){
        this.to = to;
        this.w = w;
    }
}
