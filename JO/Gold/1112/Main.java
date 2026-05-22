import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double len = Double.parseDouble(br.readLine());
        double[][] point = new double[3][2];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            point[i][0] = Double.parseDouble(st.nextToken());
            point[i][1] = Double.parseDouble(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            double a = point[i][0];
            double b = point[i][1];

            if (a == b) continue;

            double mid = (a + b) / 2.0;
            if (mid < len - mid) { // 오른쪽이 더 길떄
                for (int j = i + 1; j < 3; j++) {
                    for (int k = 0; k < 2; k++) {
                        if (point[j][k] > mid) {
                            point[j][k] = len - point[j][k];
                        } else {
                            point[j][k] += len - 2 * mid;
                        }
                    }
                }
                len -= mid;
            } else {
                for (int j = i + 1; j < 3; j++) {
                    for (int k = 0; k < 2; k++) {
                        if (point[j][k] > mid) {
                            point[j][k] = 2 * mid - point[j][k];
                        }
                    }
                }
                len = mid;
            }
        }

        System.out.printf("%.1f", len);
    }
}
