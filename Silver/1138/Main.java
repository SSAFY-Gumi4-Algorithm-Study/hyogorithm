import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] left = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (count == left[i] && answer[j] == 0) {
                    answer[j] = i + 1;
                    break;
                } else if (answer[j] == 0) count++;
            }
        }

        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }
}
