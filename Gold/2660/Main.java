import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] adj = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) adj[i][j] = Integer.MAX_VALUE;
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;

            adj[a][b] = 1;
            adj[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (adj[i][k] == Integer.MAX_VALUE || adj[k][j] == Integer.MAX_VALUE) continue;
                    if (adj[i][k] + adj[k][j] < adj[i][j]) adj[i][j] =  adj[i][k] + adj[k][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int[] score =  new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= n; j++) {
                max = Math.max(max, adj[i][j]);
            }
            score[i] = max;
            min = Math.min(min, max);
        }

        List<Integer> candidate = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (score[i] == min) {
                candidate.add(i);
            }
        }

        System.out.println(min + " " + candidate.size());
        for (int c : candidate) {
            System.out.print(c + " ");
        }
    }
}
