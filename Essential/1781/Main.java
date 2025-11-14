import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] problems = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            problems[i][0] = Integer.parseInt(st.nextToken()); // 데드라인
            problems[i][1] = Integer.parseInt(st.nextToken()); // 컵라면수
        }

        Arrays.sort(problems, (a, b) -> a[0] - b[0]); // 데드라인 기준 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(problems[i][1]); // 컵라면 수 추가
            if (pq.size() > problems[i][0]) pq.poll(); // 데드라인보다 문제 수가 더 많으면 컵라면수가 가작 적은 문제를 poll
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}
