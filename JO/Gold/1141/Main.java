import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= h) {
                stack.pop();
            }

            answer += stack.size();
            stack.push(h);
        }

        System.out.println(answer);
    }
}
