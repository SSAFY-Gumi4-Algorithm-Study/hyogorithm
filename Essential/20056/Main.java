import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<FireBall>[][] map;
    static List<FireBall> fireBalls = new ArrayList<>();
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fireBalls.add(new FireBall(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            move();
            divide();
        }

        int answer = 0;
        for (FireBall fb : fireBalls) {
            answer += fb.m;
        }

        System.out.println(answer);
    }

    static void move() {
        for (FireBall fb : fireBalls) {
            int row = (fb.r + dr[fb.d] * fb.s) % N;
            if (row < 0) row += N;

            int col = (fb.c + dc[fb.d] * fb.s) % N;
            if (col < 0) col += N;

            fb.r = row;
            fb.c = col;
            map[fb.r][fb.c].add(fb);
        }
    }

    static void divide() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c].size() <= 1){
                    map[r][c].clear();
                    continue;
                }

                int sumM = 0;
                int sumS = 0;
                boolean even = map[r][c].get(0).d % 2 == 0;
                boolean odd = map[r][c].get(0).d % 2 == 1;

                for (FireBall fb : map[r][c]){
                    sumS += fb.s;
                    sumM += fb.m;
                    even = even && fb.d % 2 == 0;
                    odd = odd && fb.d % 2 == 1;
                    fireBalls.remove(fb);
                }

                sumM /= 5;
                sumS /= map[r][c].size();
                map[r][c].clear();

                if (sumM == 0) continue;

                if (even || odd) {
                    for (int i = 0; i < 8; i += 2) {
                        fireBalls.add(new FireBall(r, c, sumM, sumS, i));
                    }
                } else {
                    for (int i = 1; i < 8; i += 2) {
                        fireBalls.add(new FireBall(r, c, sumM, sumS, i));
                    }
                }
            }
        }
    }
}

class FireBall {
    int r, c, m, s, d;

    public FireBall(int r, int c, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}
