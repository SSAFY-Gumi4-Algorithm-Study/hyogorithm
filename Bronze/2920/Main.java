import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean asc = true;
        boolean desc = true;

        for (int i = 1; i <= 8; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n != i) {
                asc = false;
            }
            if (n != 9 - i) {
                desc = false;
            }
        }

        if (asc) {
            System.out.println("ascending");
        } else if (desc) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
        br.close();
    }
}
