## 문제 요약
- `n x m` 크기의 노트북에 `r x c` 크기의 스티커들 붙이기
- 다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커를 붙일 수 있는 위치를 찾기
- 만약 스티커를 붙일 수 있는 위치가 없다면 스티커를 시계 방향으로 90도 회전한 뒤에 다시 위치 찾기
- 0도, 90도, 180도, 270도 회전해도 못붙이면 스티커 버리기
- 노트북에서 스티커가 붙은 칸 수를 출력

## 문제 풀이
- 각 스티커마다 최대 4번(0°, 90°, 180°, 270°) 회전하며 붙일 수 있는 위치를 탐색
- 현재 위치에 붙일 수 있는지 확인 (`canAttach`)
- 스티커의 1이 노트북의 1과 겹치면 불가능
- 가능한 위치를 찾으면 노트북에 스티커를 붙이고(`attach = true`), 다음 스티커로 이동
- 끝까지 못 붙이면 회전 후 다시 시도
- 모든 과정이 끝나면 노트북의 1 개수를 합산해 출력

## 전체 코드
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] notebook = new int[n][m];

        for (int s = 0; s < k; s++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[r][c];

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean attach = false;

            for (int rot = 0; rot < 4; rot++) {
                r = sticker.length;
                c = sticker[0].length;

                for (int x = 0; x <= n - r; x++) {
                    for (int y = 0; y <= m - c; y++) {

                        boolean canAttach = true;
                        for (int i = 0; i < r && canAttach; i++) {
                            for (int j = 0; j < c; j++) {
                                if (sticker[i][j] == 1 && notebook[x + i][y + j] == 1) {
                                    canAttach = false;
                                    break;
                                }
                            }
                        }

                        if (canAttach) {
                            for (int i = 0; i < r; i++) {
                                for (int j = 0; j < c; j++) {
                                    if (sticker[i][j] == 1)
                                        notebook[x + i][y + j] = 1;
                                }
                            }
                            attach = true;
                            break;
                        }
                    }
                    if (attach) break;
                }

                if (attach) break;
                sticker = rotate(sticker);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                result += notebook[i][j];

        System.out.println(result);
    }

    static int[][] rotate(int[][] arr) { // 시계 방향으로 90도 회전
        int r = arr.length;
        int c = arr[0].length;
        int[][] newArr = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newArr[j][r - i - 1] = arr[i][j];
            }
        }
        return newArr;
    }
}

```
