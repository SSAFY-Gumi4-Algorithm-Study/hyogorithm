import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            String[] num = new String[n];
            for (int i = 0; i < n; i++) {
                num[i] = br.readLine();
            }

            Arrays.sort(num);

            boolean isConsistent = true;
            for (int i = 1; i < n; i++) {
                if (num[i].startsWith(num[i - 1])) {
                    isConsistent = false;
                    break;
                }
            }
            System.out.println(isConsistent ? "YES" : "NO");
        }
    }
}
