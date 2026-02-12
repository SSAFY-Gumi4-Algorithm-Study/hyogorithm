import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int f = 0;
        int s = 0;

        for (int i = 1; i <= n; i++) {
            int tmp = find(i);

            if (f == 0) f = tmp;
            else if (f != tmp && s == 0) {
                s = tmp;
                break;
            }
        }

        System.out.println(f + " " + s);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;

        if (pa < pb) parent[pb] = pa;
        else parent[pa] = pb;
    }
}
