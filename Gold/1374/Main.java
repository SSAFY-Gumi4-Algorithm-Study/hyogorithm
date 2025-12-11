import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, (a, b) -> a.start - b.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].end);

        int max = 1;
        for (int i = 1; i < n; i++) {
            if (pq.peek() <= lectures[i].start) pq.poll();
            pq.add(lectures[i].end);
            max = Math.max(max, pq.size());
        }

        System.out.println(max);
    }
}

class Lecture {
    int start, end;
    Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
