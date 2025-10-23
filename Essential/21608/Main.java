import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] classroom;
    static List<Integer>[] like;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        classroom = new int[n][n];
        like = new ArrayList[n * n + 1];
        order = new int[n * n];

        for (int i = 1; i <= n * n; i++) {
            like[i] = new ArrayList<>();
        }

        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            order[i] = student;
            for (int j = 0; j < 4; j++) {
                like[student].add(Integer.parseInt(st.nextToken()));
            }
        }

        assignSeat();
        System.out.println(calculate());
    }

    static void assignSeat() {
        for (int i = 0; i < n * n; i++) {
            int student = order[i];
            Point seat = findBestSeat(student);
            classroom[seat.x][seat.y] = student;
        }
    }

    static Point findBestSeat(int student) {
        PriorityQueue<Point> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.like != b.like) return b.like - a.like;
                    if (a.empty != b.empty) return b.empty - a.empty;
                    if (a.x != b.x) return a.x - b.x;
                    return a.y - b.y;
                }
        );

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (classroom[x][y] != 0) continue;

                int likeCount = 0;
                int emptyCount = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                    if (classroom[nx][ny] == 0) emptyCount++;
                    else if (like[student].contains(classroom[nx][ny])) likeCount++;
                }

                pq.offer(new Point(x, y, emptyCount, likeCount));
            }
        }

        return pq.poll();
    }

    static int calculate() {
        int[] score = {0, 1, 10, 100, 1000};
        int total = 0;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int student = classroom[x][y];
                int cnt = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                    if (like[student].contains(classroom[nx][ny])) cnt++;
                }

                total += score[cnt];
            }
        }
        return total;
    }
}

class Point {
    int x, y, empty, like;

    public Point(int x, int y, int empty, int like) {
        this.x = x;
        this.y = y;
        this.empty = empty;
        this.like = like;
    }
}
