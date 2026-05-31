import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][][] v;
    static int[] dr = {0, 0, 0, 1, -1};
    static int[] dc = {0, 1, -1, 0, 0};
    static int startR, startC, startDir;
    static int endR, endC, endDir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m + 1][n + 1];
        v = new boolean[m + 1][n + 1][5];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startR = Integer.parseInt(st.nextToken());
        startC = Integer.parseInt(st.nextToken());
        startDir = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        endR = Integer.parseInt(st.nextToken());
        endC = Integer.parseInt(st.nextToken());
        endDir = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Robot> q = new ArrayDeque<>();

        q.offer(new Robot(startR, startC, startDir, 0));
        v[startR][startC][startDir] = true;

        while (!q.isEmpty()) {
            Robot cur = q.poll();

            if (cur.r == endR && cur.c == endC && cur.dir == endDir) return cur.count;

            // 이동
            for (int k = 1; k <= 3; k++) {
                int nr = cur.r + dr[cur.dir] * k;
                int nc = cur.c + dc[cur.dir] * k;

                if (nr < 1 || nr > m || nc < 1 || nc > n || map[nr][nc] == 1) break;
                if (v[nr][nc][cur.dir]) continue;

                v[nr][nc][cur.dir] = true;
                q.offer(new Robot(nr, nc, cur.dir, cur.count + 1));
            }

            // 회전
            int leftDir = turnLeft(cur.dir);
            if (!v[cur.r][cur.c][leftDir]) {
                v[cur.r][cur.c][leftDir] = true;
                q.offer(new Robot(cur.r, cur.c, leftDir, cur.count + 1));
            }

            int rightDir = turnRight(cur.dir);
            if (!v[cur.r][cur.c][rightDir]) {
                v[cur.r][cur.c][rightDir] = true;
                q.offer(new Robot(cur.r, cur.c, rightDir, cur.count + 1));
            }
        }

        return -1;
    }

    static int turnLeft(int dir) {
        if (dir == 1) return 4;
        if (dir == 2) return 3;
        if (dir == 3) return 1;
        return 2;
    }

    static int turnRight(int dir) {
        if (dir == 1) return 3;
        if (dir == 2) return 4;
        if (dir == 3) return 2;
        return 1;
    }
}

class Robot {
    int r, c, dir, count;

    Robot(int r, int c, int dir, int count) {
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.count = count;
    }
}
