import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, depth;
    static boolean[] v;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        depth = new int[n + 1];
        v = new boolean[n + 1];
        adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        bfs();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        v[1] = true;
        parent[1] = 0;
        depth[1] = 0;

        while (!q.isEmpty()) {
            int c = q.poll();

            for (int nxt : adj[c]) {
                if(!v[nxt]) {
                    q.add(nxt);
                    v[nxt] = true;
                    parent[nxt] = c;
                    depth[nxt] = depth[c] + 1;
                }
            }
        }
    }

    static int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = b;
            b = a;
            a = temp;
        }

        while (depth[a] != depth[b]) {
            b = parent[b];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}
