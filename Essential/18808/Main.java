import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] paper = new int[n][m];

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
                                if (sticker[i][j] == 1 && paper[x + i][y + j] == 1) {
                                    canAttach = false;
                                    break;
                                }
                            }
                        }

                        if (canAttach) {
                            for (int i = 0; i < r; i++) {
                                for (int j = 0; j < c; j++) {
                                    if (sticker[i][j] == 1)
                                        paper[x + i][y + j] = 1;
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
                result += paper[i][j];

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
