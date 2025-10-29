import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        int answer = 0;

        while (true) {
            char last = t.charAt(t.length() - 1);
            if (last == 'A') t = t.substring(0, t.length() - 1);
            else if (last == 'B') {
                t = t.substring(0, t.length() - 1);
                StringBuilder sb = new StringBuilder(t);
                t = sb.reverse().toString();
            }

            if (t.equals(s)) {
                answer = 1;
                break;
            }

            if (t.length() == 1) break;
        }

        System.out.println(t.equals(s) ? 1 : 0);
    }
}
