import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n + 1][n + 1];
        for (int i = 1; i <= n ; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 1; j <= n ; j++) {
                if (i == j) continue;
                cost[i][j] = row[j - 1] == 'Y' ? 1 : Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                for (int k = 1; k <= n; k++){
                    if (j == k || cost[j][i] == Integer.MAX_VALUE || cost[i][k] == Integer.MAX_VALUE) continue;
                    cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n ; i++) {
            int cnt = 0;
            for (int j = 1; j <= n ; j++) {
                if(cost[i][j] == 2 || cost[i][j] == 1){
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
