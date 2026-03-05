import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int min = Integer.MAX_VALUE;
            int ans = 0;

            for (int i = 0; i < n; i++){
                int now = arr[i];
                int left = i + 1;
                int right = n - 1;
                int mid = 0;
                while (left <= right) {
                    mid = (left + right) / 2;
                    int tmp = now + arr[mid];
                    if (tmp < k){
                        left = mid + 1;
                        if (min > (k - tmp)) {
                            ans = 1;
                            min = k - tmp;
                        } else if (min == (k - tmp)) ans++;
                    } else {
                        right = mid - 1;
                        if (min > (tmp - k)) {
                            ans = 1;
                            min = tmp - k;
                        } else if (min == (tmp - k)) ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
