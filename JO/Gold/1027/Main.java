import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bt("");
    }

    static void bt(String str) {
        if (str.length() == n) {
            System.out.println(str);
            System.exit(0);
        }

        for (int num = 1; num <= 3; num++) {
            String next = str + num;
            boolean possible = true;

            for (int len = 1; len <= next.length() / 2; len++) {
                int end = next.length();

                String right = next.substring(end - len, end);
                String left = next.substring(end - len * 2, end - len);

                if (left.equals(right)) {
                    possible = false;
                    break;
                }
            }

            if (possible) bt(next);
        }
    }
}
