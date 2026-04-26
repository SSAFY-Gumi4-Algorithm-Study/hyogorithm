import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] select;
    static boolean[] v;
    static boolean[] finished;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());

            select = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                select[i] = Integer.parseInt(st.nextToken());
            }

            v = new boolean[n + 1];
            finished = new boolean[n + 1];
            answer = 0;
            for (int i = 1; i <= n; i++) {
                if (!v[i]) {
                    dfs(i);
                }
            }

            sb.append(n - answer).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int now) {
        v[now] = true;
        int next = select[now];

        if (!v[next]) {
            dfs(next);
        } else if (!finished[next]) {
            answer++;
            for (int i = next; i != now; i = select[i]) {
                answer++;
            }
        }

        finished[now] = true;
    }
}
