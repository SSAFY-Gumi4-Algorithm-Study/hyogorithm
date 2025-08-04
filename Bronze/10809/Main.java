import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int i = 97; i < 123; i++) {
            System.out.print(s.indexOf((char)i) + " ");
        }

        br.close();
    }
}