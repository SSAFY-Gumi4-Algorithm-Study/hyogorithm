import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		
		double sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			nums[i] = num;
			sum += num; 
			min = Math.min(min, num);
			max = Math.max(max, num);
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		Arrays.sort(nums);
		
		int maxCnt = 0;
		for (int num : map.values()) {
			maxCnt = Math.max(maxCnt, num);
		}
		
		List<Integer> maxCntList = new ArrayList<>();
		for (int key : map.keySet()) {
			if (map.get(key) == maxCnt) maxCntList.add(key);
		}
		Collections.sort(maxCntList);
		
		System.out.println(Math.round(sum / n));
		System.out.println(nums[n / 2]);
		
		if (maxCntList.size() >= 2) System.out.println(maxCntList.get(1));
		else System.out.println(maxCntList.get(0));
		
		System.out.println(max - min);
	}
}
