import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (min.size() == max.size()) max.offer(num);
            else min.offer(num);

            if (!min.isEmpty() && !max.isEmpty()) {
                if (max.peek() > min.peek()) {
                    min.offer(max.poll());
                    max.offer(min.poll());
                }
            }
            
            System.out.println(max.peek());
        }
    }
}
