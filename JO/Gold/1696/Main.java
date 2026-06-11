import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] map;
    static int[][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dijkstra();

        System.out.println(dist[n - 1][n - 1]);
    }

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[2]));
        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];

            if (cnt > dist[r][c]) continue;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                int nextCnt = cnt;
                if (map[nr][nc] == '0') nextCnt++;

                if (nextCnt < dist[nr][nc]) {
                    dist[nr][nc] = nextCnt;
                    pq.offer(new int[]{nr, nc, nextCnt});
                }
            }
        }
    }
}
