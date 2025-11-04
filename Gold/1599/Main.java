import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] word = new String[n];
        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }

        String[] minsik = {"a", "b", "k", "d", "e", "g", "h", "i", "l", "m", "n", "ng", "o", "p", "r", "s", "t", "u", "w", "y"};

        Map<String, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < minsik.length; i++) {
            orderMap.put(minsik[i], i);
        }

        Arrays.sort(word, (a, b) -> {
            List<Integer> listA = convertToOrderList(a, orderMap);
            List<Integer> listB = convertToOrderList(b, orderMap);

            int len = Math.min(listA.size(), listB.size());
            for (int i = 0; i < len; i++) {
                int diff = listA.get(i) - listB.get(i);
                if (diff != 0) return diff;
            }
            return listA.size() - listB.size();
        });

        for (String w : word) {
            System.out.println(w);
        }
    }

    private static List<Integer> convertToOrderList(String word, Map<String, Integer> orderMap) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (i < word.length() - 1 && word.charAt(i) == 'n' && word.charAt(i + 1) == 'g') {
                list.add(orderMap.get("ng"));
                i++; // g 건너뛰기
            } else {
                list.add(orderMap.get(String.valueOf(word.charAt(i))));
            }
        }
        return list;
    }
}
