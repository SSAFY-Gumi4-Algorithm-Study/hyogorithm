import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];

        answer[0] = n / 2 + 1;
        for (int i = 2; i < n; i += 2) {
            answer[i] = answer[i - 2] + 1;
        }

        if (n != 1) {
            answer[1] = answer[0] - 1;
            for (int i = 3; i < n; i += 2) {
                answer[i] = answer[i - 2] - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
