import java.io.*;
import java.util.*;

public class Main {
    static String str;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader((System.in))));
        str = br.readLine();
        v = new boolean[str.length()];

        zoac(0, str.length() - 1);
        System.out.println(sb);
    }

    private static void zoac(int l, int r) {
        if (l > r) return;

        int idx = l;
        for (int i = l; i <= r; i++) {
            if (str.charAt(idx) > str.charAt(i)) idx = i;
        }
        v[idx] = true;

        for (int i = 0; i < str.length(); i++) {
            if (v[i]) sb.append(str.charAt(i));
        }
        sb.append("\n");

        zoac(idx + 1, r);
        zoac(l, idx - 1);
    }
}
