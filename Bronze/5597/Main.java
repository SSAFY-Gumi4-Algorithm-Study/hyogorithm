import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> students = new ArrayList<>();
        for (int i = 0; i < 28; i++) {
            students.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(students);

        for (int i = 1; i <= 30; i++) {
            if (!students.contains(i)) System.out.println(i);
        }
    }
}
