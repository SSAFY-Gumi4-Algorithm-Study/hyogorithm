import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int max = -1;
    static int[][] dice;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dice = new int[n][6];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 6; i++) {
            search(1, i, 0);
        }

        System.out.println(max);
    }

    static void search(int count, int bottom, int sum) {
        int pair;

        if (bottom == 0) pair = 5;
        else if (bottom == 1) pair = 3;
        else if (bottom == 2) pair = 4;
        else if (bottom == 3) pair = 1;
        else if (bottom == 4) pair = 2;
        else pair = 0;

        int temp = -1;
        for (int i = 0; i < 6; i++) {
            if (i == pair || i == bottom) continue;
            temp = Math.max(temp, dice[count - 1][i]);
        }

        sum += temp;

        if (count == n) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (dice[count - 1][pair] == dice[count][i]) {
                search(count + 1, i, sum);
                break;
            }
        }
    }
}
