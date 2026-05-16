import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> prime = new HashSet<>();
    static Set<Integer> v = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for (int i = 1000; i <= 9999; i++) {
            if (isPrime(i))
                prime.add(i);
        }

        System.out.println(bfs(start, end));
    }

    static boolean isPrime(int num) {
        if (num == 2) return true;
        if (num % 2 == 0 || num < 2) return false;

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }

    static int bfs(int start, int end) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0});
        v.add(start);

        while (!queue.isEmpty()) {
            int[] c = queue.poll();

            if (c[0] == end) return c[1];

            char[] nums = String.valueOf(c[0]).toCharArray();

            for (int i = 0; i < 4; i++) {
                char temp = nums[i];

                for (char ch = '0'; ch <= '9'; ch++) {
                    if (nums[i] == ch) continue;

                    nums[i] = ch;
                    int next = Integer.parseInt(new String(nums));

                    if (prime.contains(next) && !v.contains(next)) {
                        v.add(next);
                        queue.offer(new int[]{next, c[1] + 1});
                    }
                }

                nums[i] = temp;
            }
        }

        return -1;
    }
}
