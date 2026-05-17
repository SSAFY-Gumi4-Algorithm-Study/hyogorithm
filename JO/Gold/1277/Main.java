import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] camp;
    static int sr, sc, er, ec;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        camp = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < n; j++) {
                camp[i][j] = line.charAt(j);

                if (camp[i][j] == 'S') {
                    sr = i;
                    sc = j;
                } else if (camp[i][j] == 'E') {
                    er = i;
                    ec = j;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (camp[i][j] == '.' && bfs(i, j)) {
                    camp[i][j] = 'o';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(camp[i][j]);
            }
            System.out.println();
        }
    }

    static boolean bfs(int blockR, int blockC) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[n][n];
        q.offer(new int[]{sr, sc});
        v[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] c = q.poll();

            if (c[0] == er && c[1] == ec) return false;

            for (int d = 0; d < 4; d++) {
                int nr = c[0] + dr[d];
                int nc = c[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (nr == blockR && nc == blockC) continue;

                if (!v[nr][nc] && camp[nr][nc] != '#') {
                    v[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return true;
    }
}
