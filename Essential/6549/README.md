## 문제 요약
- 너비가 1이고 높이는 다양한 히스토그램에서 가장 넓이가 큰 직사각형의 넓이 구하기

## 문제 풀이
- 현재 높이가 스택의 `top`에 있는 막대기보다 작으면, 스택에서 `pop` -> 직사각형의 넓이를 계산
- 현재 높이가 스택의 `top`에 있는 높이보다 크거나 같으면, 해당 막대기를 스택에 `push`
-> 스택은 높이가 작은거부터 큰 순서로 쌓인다

## 코드
```java
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			if (n == 0) break;
			
			long[] height = new long[n];
			for (int i = 0; i < n; i++) height[i] = Long.parseLong(st.nextToken());
			
			Deque<Integer> stack = new ArrayDeque<Integer>();
			long max = 0;
			
            for (int i = 0; i <= n; i++) {
            	long c = (i == n) ? 0 : height[i];

                while (!stack.isEmpty() && height[stack.peek()] > c) {
                    long h = height[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = Math.max(max, h * w);
                }
                stack.push(i);
            }
            
			System.out.println(max);
		}
	}
}
```
