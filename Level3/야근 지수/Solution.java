import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long sum = 0;
        for (int w : works) sum += w;
        if (sum <= n) return 0;

        Integer[] arr = Arrays.stream(works).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            int diff = arr[i] - arr[i + 1];
            int count = i + 1;
            long need = (long) diff * count;

            if (n >= need) {
                for (int j = 0; j <= i; j++) {
                    arr[j] = arr[i + 1];
                }
                n -= need;
            } else {
                int q = n / count;
                int r = n % count;

                for (int j = 0; j <= i; j++) {
                    arr[j] -= q;
                }
                for (int j = 0; j < r; j++) {
                    arr[j]--;
                }

                n = 0;
                break;
            }
        }

        if (n > 0) {
            int q = n / len;
            int r = n % len;

            for (int i = 0; i < len; i++) {
                arr[i] -= q;
            }
            for (int i = 0; i < r; i++) {
                arr[i]--;
            }
        }

        long answer = 0;
        for (int w : arr) {
            if (w > 0) answer += (long) w * w;
        }

        return answer;
    }
}
