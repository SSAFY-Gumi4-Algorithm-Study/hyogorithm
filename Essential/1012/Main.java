import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] grid = new int[n][m];

            for (int i = 0; i < k; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                grid[y][x] = 1;
            }

            int cnt = 0;
            boolean[][] v = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!v[i][j] && grid[i][j] == 1) {
                        bfs(j, i, v, grid, n, m);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
        br.close();
    }
    
    static void bfs(int sx, int sy, boolean v[][], int[][] grid, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sx, sy });
        v[sy][sx] = true;
        
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };
        
        while (!q.isEmpty()) {
            int[] c = q.poll();
            int cx = c[0];
            int cy = c[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (!v[ny][nx] && grid[ny][nx] == 1) {
                        v[ny][nx] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
