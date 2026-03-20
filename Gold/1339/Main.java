import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader((System.in))));
        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                int value = (int) Math.pow(10, words[i].length() - j - 1);
                map.put(ch, map.getOrDefault(ch, 0) + value);
            }
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        int num = 9;
        int sum = 0;

        for (int value : list) {
            sum += value * num;
            num--;
        }

        System.out.println(sum);
    }
}
