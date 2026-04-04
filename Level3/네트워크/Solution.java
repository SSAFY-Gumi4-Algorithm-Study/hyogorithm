import java.util.*;

class Solution {
    static List<List<Integer>> adj = new ArrayList<>();
    static boolean[] v;
    
    public int solution(int n, int[][] computers) {
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        
        v = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                bfs(i);
                count++;
            }
        }
        
        return count;
    }
    
    private void bfs(int s) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        
        while (!q.isEmpty()) {
            int c = q.poll();
            
            for (int next : adj.get(c))
            if (!v[next]) {
                v[next] = true;
                q.add(next);
            }
        }
    }
}
