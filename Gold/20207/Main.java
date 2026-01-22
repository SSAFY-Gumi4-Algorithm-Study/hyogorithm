import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] days = new int[366];

        int first = 366;
        int last = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s; j <= e; j++) {
                days[j]++;
            }
            first = Math.min(first,s);
            last = Math.max(last, e);
        }

        int w = 0;
        int h = 0;
        int sum = 0;
        for (int i = first; i <= last; i++) {
            if (days[i] == 0) {
                sum += w * h;
                w = 0;
                h = 0;
            } else {
                w++;
                h = Math.max(h, days[i]);
            }
        }
        sum += w * h;

        System.out.println(sum);
    }
}
