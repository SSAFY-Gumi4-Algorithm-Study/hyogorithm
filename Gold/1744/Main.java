import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());

        List<Integer> nums = new  ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }
        nums.sort(Collections.reverseOrder());

        int sum = 0;
        int i = 0;
        while (i + 1 < n && nums.get(i) > 1 && nums.get(i + 1) > 1) {
            sum += nums.get(i) * nums.get(i + 1);
            i += 2;
        }

        while (i < n && nums.get(i) == 1) {
            sum += 1;
            i++;
        }

        int j = n - 1;
        while (j - 1 >= i && nums.get(j) < 0 && nums.get(j - 1) < 0) {
            sum += nums.get(j) * nums.get(j - 1);
            j -= 2;
        }

        for (int k = i; k <= j; k++) {
            sum += nums.get(k);
        }

        if (nums.contains(0) && j >= i && nums.get(j) < 0) sum -= nums.get(j);
        System.out.println(sum);
    }
}
