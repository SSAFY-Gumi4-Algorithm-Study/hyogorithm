import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static int[] inD;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        inD = new int[n + 1];
        answer = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int from, to;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            inD[to]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            if(inD[i] == 0) {
                q.offer(i);
                answer[i] = 1;
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int i : graph[node]) {
                inD[i]--;
                answer[i] = Math.max(answer[i], answer[node] + 1);
                if(inD[i] == 0) {
                    q.offer(i);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
