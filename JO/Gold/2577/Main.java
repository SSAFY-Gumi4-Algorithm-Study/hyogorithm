import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        count[c] = 1;
        int kinds = 1;

        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) kinds++;
            count[sushi[i]]++;
        }

        int answer = kinds;

        for (int start = 1; start < n; start++) {
            int left = sushi[start - 1];
            count[left]--;
            if (count[left] == 0) kinds--;

            int right = sushi[(start + k - 1) % n];
            if (count[right] == 0) kinds++;
            count[right]++;

            if (kinds > answer) answer = kinds;
        }

        System.out.println(answer);
    }
}
