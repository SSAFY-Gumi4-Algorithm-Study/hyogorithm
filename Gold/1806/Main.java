import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int length = 0;
        int answer = Integer.MAX_VALUE;
        int l = 0, r = 0;
        while (r <= n) {
            if (sum >= s) {
                sum -= arr[l++];
                length = r - l + 1;
                answer = Math.min(answer, length);
            } else {
                sum += arr[r++];
            }
        }
      
        if (answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);
    }
}
