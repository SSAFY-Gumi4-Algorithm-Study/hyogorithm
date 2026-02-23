import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.x != b.x ? Integer.compare(a.x, b.x) : Integer.compare(a.y, b.y));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x =  Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.offer(new Point(x, y));
        }

        Point first = pq.poll();
        int start = first.x;
        int end = first.y;
        int answer = 0;

        while (!pq.isEmpty()) {
            Point c = pq.poll();

            if (c.x > end) {
                answer += end - start;
                start = c.x;
                end = c.y;
                continue;
            }

            if (c.y > end) end = c.y;
        }

        answer += end - start;
        System.out.println(answer);
    }
}

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
