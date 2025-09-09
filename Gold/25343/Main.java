import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = 0; x <= i; x++) {
                	for (int y = 0; y <= j; y++) {
                		if ((x != i || y != j) && arr[x][y] < arr[i][j]) {
                			dp[i][j] = Math.max(dp[i][j], dp[x][y] + 1);
                		}
                	}
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		ans = Math.max(dp[i][j], ans);
        	}
        }
        System.out.println(ans);
    }
}

