import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> back = new Stack<>();
        Stack<String> forward = new Stack<>();

        String current = "http://www.acm.org/";

        while (true) {
            String command = br.readLine().trim();

            if (command.equals("QUIT")) break;

            if (command.equals("BACK")) {
                if (back.isEmpty()) {
                    sb.append("Ignored\n");
                } else {
                    forward.push(current);
                    current = back.pop();
                    sb.append(current).append('\n');
                }
            } else if (command.equals("FORWARD")) {
                if (forward.isEmpty()) {
                    sb.append("Ignored\n");
                } else {
                    back.push(current);
                    current = forward.pop();
                    sb.append(current).append('\n');
                }
            } else if (command.startsWith("VISIT")) {
                String url = command.substring(6);

                back.push(current);
                current = url;
                forward.clear();

                sb.append(current).append('\n');
            }
        }

        System.out.print(sb);
    }
}
