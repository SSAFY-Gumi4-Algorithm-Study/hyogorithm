import java.io.*;
import java.util.*;

public class Main {
    static int n, remove;
    static int count = 0;
    static boolean v[];
    static List<Integer> tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        v = new boolean[n];

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p != -1) {
                tree[p].add(i);
            } else {
                root = i;
            }
        }

        remove = Integer.parseInt(br.readLine());

        if (remove == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(count);
        }
    }

    static void dfs(int node) {
        v[node] = true;
        int child = 0;
        for (int i : tree[node]) {
            if (i != remove && !v[i]) {
                child++;
                dfs(i);
            }
        }
        if (child == 0) {
            count++;
        }
    }
}
