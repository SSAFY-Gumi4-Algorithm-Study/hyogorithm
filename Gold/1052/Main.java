import java.io.*;
import java.util.*;

public class Main {
    static TreeSet<Integer> answer = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = 0;
        while (Integer.bitCount(n) > k) {
            answer++;
            n++;
        }

        System.out.println(answer);
    }
}
