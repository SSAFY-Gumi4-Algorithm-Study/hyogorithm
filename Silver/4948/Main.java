import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
        	int n = Integer.parseInt(br.readLine());
        	if (n == 0) break;
        	int cnt = 0;
        	for (int i = n + 1; i <= n * 2; i++) {
        		if (isPrime(i)) cnt++;
        	}
        	System.out.println(cnt);
        }
    }

    static boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0 || num < 2) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
