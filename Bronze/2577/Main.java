import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        String m = "" + (a * b * c);
        int[] result = new int[10];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < m.length(); j++) {
                int n = m.charAt(j) - '0';
                if (n == i) {
                    result[i]++;
                }
            }
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println(result[i]);
        }
        
        br.close();
    }
}
