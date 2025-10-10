import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int conn = Integer.parseInt(st.nextToken());
                if (conn == 1) union(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < m; i++){
            int c = Integer.parseInt(st.nextToken());
            if (start != find(c)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;

        if (pa < pb) parent[pb] = pa;
        else parent[pa] = pb;
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
