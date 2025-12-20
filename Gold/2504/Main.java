import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int value = 1;

        for (int i = 0; i < str.length(); i++) {
            if  (str.charAt(i) == '(') {
                stack.push('(');
                value *= 2;
            }  else if (str.charAt(i) == '[') {
                stack.push('[');
                value *= 3;
            } else if (str.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                } else if (str.charAt(i - 1) == '(') {
                    answer += value;
                }
                stack.pop();
                value /= 2;
            } else if (str.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                } else if (str.charAt(i - 1) == '[') {
                    answer += value;
                }
                stack.pop();
                value /= 3;
            }
        }
      
        if (!stack.isEmpty()) answer = 0;
        System.out.println(answer);
    }
}
