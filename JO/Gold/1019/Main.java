import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sum = new int[n + 1]; // 1번 객차부터 i번 객차까지의 승객 수 합

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[][] dp = new int[4][n + 1]; // 소형기관차 train대를 사용해서 1번부터 i번 객차까지 고려했을 때의 최대 승객 수

        for (int train = 1; train <= 3; train++) {
            for (int i = train * m; i <= n; i++) {
                int current = sum[i] - sum[i - m];
                // 1. i번째 객차를 선택하지 않음
                // 2. i번째 객차를 끝으로 m칸을 선택
                dp[train][i] = Math.max(dp[train][i - 1], dp[train - 1][i - m] + current);
            }
        }

        System.out.println(dp[3][n]);
    }
}
