import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] bottom = new int[h + 1];
        int[] top = new int[h + 1];

        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(br.readLine());
            if (i % 2 == 0) bottom[len]++;
            else top[len]++;
        }

        for (int i = h - 1; i >= 1; i--) {
            // 길이가 i 이상인 석순/종유석의 개수
            bottom[i] += bottom[i + 1];
            top[i] += top[i + 1];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for (int k = 1; k <= h; k++) {
            int hit = bottom[k] + top[h - k + 1];

            if (hit < min) {
                min = hit;
                cnt = 1;
            } else if (hit == min) {
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);
    }
}
