import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> mod = new HashSet<Integer>();
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            mod.add(n % 42);
        }
        System.out.println(mod.size());
        br.close();
    }
}
