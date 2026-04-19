import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] children;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) children[parent].add(i);
        }

        dp = new int[n];
        dfs(0);

        System.out.println(dp[0]);
    }

    static void dfs(int u) {
        List<Integer> times = new ArrayList<>();

        for (int v : children[u]) {
            dfs(v);
            times.add(dp[v]);
        }

        // 오래 걸리는 부하부터 먼저 연락
        times.sort(Collections.reverseOrder());

        int time = 0;
        for (int i = 0; i < times.size(); i++) {
            time = Math.max(time, times.get(i) + i + 1);
        }
        
        dp[u] = time;
    }
}
