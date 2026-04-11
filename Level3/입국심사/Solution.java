import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = 0;
        
        for (int time : times) {
            right = Math.max(right, time);
        }
        right *= n;
        
        long answer = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0; // 각 심사관이 mid 시간 동안 처리할 수 있는 사람 수
            
            for (int time : times) {
                count += mid / time;
                if (count >= n) break;
            }
            
            if (count >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}
