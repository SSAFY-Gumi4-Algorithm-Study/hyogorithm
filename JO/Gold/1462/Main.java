import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                char ch = row.charAt(j);
                if (ch == 'W') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }

        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 1) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        System.out.println(answer);

    }

    static int bfs(int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>();
        v = new boolean[r][c];
        int maxDist = 0;

        q.offer(new int[]{sr, sc, 0});
        v[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            maxDist = Math.max(maxDist, cur[2]);

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                if (!v[nr][nc] && map[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc,  cur[2] + 1});
                    v[nr][nc] = true;
                }
            }

        }
        return maxDist;
    }
}
