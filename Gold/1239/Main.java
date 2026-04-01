import java.io.*;
import java.util.*;

public class Main3 {
    static int n;
    static int max = 0;
    static int[] arr;
    static int[] dogs;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dogs = new int [n];
        arr = new int[n];
        v = new boolean [n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dogs[i] = Integer.parseInt(st.nextToken());
            if (dogs[i] > 50) {
                System.out.println(0);
                return;
            } else if (dogs[i] == 50) {
                System.out.println(1);
                return;
            }
        }

        dfs(0);
        System.out.println(max);
    }

    static void calc() {
        int l = 0;
        int r = 1;
        int sum = arr[0];
        int cnt = 0;
        while (r < n) {
            if (sum == 50) {
                cnt++;
                sum += arr[r++];
                sum -= arr[l++];
            } else if (sum > 50) {
                sum -= arr[l++];
            } else {
                sum += arr[r++];
            }
        }
        while (sum > 50 && l < r) {
            sum -= arr[l++];
        }
        max = Math.max(max, cnt);
    }

    static void dfs(int idx) {
        if (idx == n) calc();
        else {
            for (int i = 0 ; i < n; i++) {
                if (!v[i]) {
                    v[i] = true;
                    arr[idx] = dogs[i];
                    dfs(idx + 1);
                    v[i] = false;
                }
            }
        }
    }
}
