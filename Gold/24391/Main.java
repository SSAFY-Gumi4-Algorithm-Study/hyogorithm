import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> adj;
    static boolean[] v;
    static int[] group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(b).add(a);
            adj.get(a).add(b);
        }

        int[] lectures = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
        }

        v = new boolean[n + 1];
        group = new int[n + 1];

        int groupNum = 1;
        for (int i = 1; i <= n; i++) {
            if (!v[i]) {
                bfs(i, groupNum);
                groupNum++;
            }
        }

        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            if (group[lectures[i]] != group[lectures[i + 1]]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void bfs(int s, int groupNum) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        v[s] = true;
        group[s] = groupNum;

        while (!q.isEmpty()) {
            int c = q.poll();

            for (int next : adj.get(c)) {
                if(!v[next]) {
                    v[next] = true;
                    group[next] = groupNum;
                    q.add(next);
                }
            }
        }
    }
}
