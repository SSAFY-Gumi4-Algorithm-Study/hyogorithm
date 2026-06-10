import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int l = 0;
        int r = n - 1;
        int count = 0;

        while (l < r) {
            int sum = arr[l] + arr[r];

            if (sum == m) {
                count++;
                l++;
                r--;
            } else if (sum < m) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(count);
    }
}
