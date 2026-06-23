import java.io.*;
import java.util.*;

public class Main {
    static int[][] cost;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = v * (v - 1) / 2;
        cost = new int[e][3];

        int idx = 0;
        for (int i = 1; i <= v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= v; j++) {
                int c = Integer.parseInt(st.nextToken());

                if (i < j) {
                    cost[idx][0] = i;
                    cost[idx][1] = j;
                    cost[idx][2] = c;
                    idx++;
                }
            }
        }

        Arrays.sort(cost, (a, b) -> a[2] - b[2]);

        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        int sum = 0;
        int count = 0;
        for (int i = 0; i < e; i++) {
            if (find(cost[i][0]) != find(cost[i][1])) {
                union(cost[i][0], cost[i][1]);
                sum += cost[i][2];
                count++;

                if (count == v - 1) {
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return false;

        if (pa < pb) parent[pb] = pa;
        else parent[pa] = pb;

        return true;
    }
}
