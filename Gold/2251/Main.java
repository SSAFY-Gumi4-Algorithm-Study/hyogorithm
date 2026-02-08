import java.io.*;
import java.util.*;

public class Main {
    static TreeSet<Integer> answer = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        bfs(A, B, C);

        for(int ans : answer){
            System.out.print(ans + " ");
        }
    }

    static void bfs(int A, int B, int C) {
        Queue<Water> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[201][201][201];
        q.offer(new Water(0, 0, C));
        visited[0][0][C] = true;

        while (!q.isEmpty()) {
            Water cur = q.poll();

            if (cur.A == 0) answer.add(cur.C);

            int tempA, tempB, tempC;
            // A → B
            tempA = cur.A - Math.min(cur.A, B - cur.B);
            tempB = cur.B + Math.min(cur.A, B - cur.B);
            tempC = cur.C;
            checkWater(visited, tempA, tempB, tempC, q);

            // A → C
            tempA = cur.A - Math.min(cur.A, C - cur.C);
            tempB = cur.B;
            tempC = cur.C + Math.min(cur.A, C - cur.C);
            checkWater(visited, tempA, tempB, tempC, q);

            // B → A
            tempA = cur.A + Math.min(cur.B, A - cur.A);
            tempB = cur.B - Math.min(cur.B, A - cur.A);
            tempC = cur.C;
            checkWater(visited, tempA, tempB, tempC, q);

            // B → C
            tempA = cur.A;
            tempB = cur.B - Math.min(cur.B, C - cur.C);
            tempC = cur.C + Math.min(cur.B, C - cur.C);
            checkWater(visited, tempA, tempB, tempC, q);

            // C → A
            tempA = cur.A + Math.min(cur.C, A - cur.A);
            tempB = cur.B;
            tempC = cur.C - Math.min(cur.C, A - cur.A);
            checkWater(visited, tempA, tempB, tempC, q);

            // C → B
            tempA = cur.A;
            tempB = cur.B + Math.min(cur.C, B - cur.B);
            tempC = cur.C - Math.min(cur.C, B - cur.B);
            checkWater(visited, tempA, tempB, tempC, q);
        }
    }

    private static void checkWater(boolean[][][] visited, int tempA, int tempB, int tempC, Queue<Water> q) {
        if (!visited[tempA][tempB][tempC]) {
            visited[tempA][tempB][tempC] = true;
            q.offer(new Water(tempA, tempB, tempC));
        }
    }
}

class Water {
    int A, B, C;
    Water(int a, int b, int c) {
        A = a;
        B = b;
        C = c;
    }
}
