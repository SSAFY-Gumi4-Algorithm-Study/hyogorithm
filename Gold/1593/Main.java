import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int g = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        String W = br.readLine();
        String S = br.readLine();

        int wArr[] = new int[52];
        int sArr[] = new int[52];

        for (int i = 0; i < g; i++) {
            char index = W.charAt(i);
            addArr(index, 1, wArr);
        }

        int answer = 0;
        for (int i = 0; i < s; i++) {
            char index = S.charAt(i);

            if (i >= g) {
                addArr(S.charAt(i - g), -1, sArr);
            }

            addArr(index, 1, sArr);

            if (Arrays.equals(wArr, sArr)) answer++;
        }

        System.out.println(answer);
    }

    private static void addArr(char c, int value, int[] arr) {
        if ('a' <= c && c <= 'z') arr[c - 'a'] += value;
        else arr[c - 'A' + 26] += value;
    }
}
