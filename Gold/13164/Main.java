import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader((System.in))));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] h = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            h[i] = Integer.parseInt(st.nextToken());


        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            diff[i] = h[i + 1] - h[i];

        Arrays.sort(diff);

        int answer = 0;
        for (int i = 0; i < n - k; i++) 
            answer += diff[i];

        System.out.println(answer);
    }
}
