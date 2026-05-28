import java.io.*;

class Main {
    static int N;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(1, 0, 1, "1");
        sb.append(count).append('\n');
        System.out.print(sb);
    }

    static void dfs(int n, int sum, int last, String formula) {
        if (n == N) {
            if (sum + last == 0) {
                count++;

                if (count <= 20) {
                    sb.append(formula).append('\n');
                }
            }
            return;
        }

        int next = n + 1;
        dfs(next, sum + last, next, formula + " + " + next);
        dfs(next, sum + last, -next, formula + " - " + next);

        int digit = getDigit(next);
        if (last >= 0) {
            dfs(next, sum, last * digit + next, formula + " . " + next);
        } else {
            dfs(next, sum, last * digit - next, formula + " . " + next);
        }
    }

    static int getDigit(int num) {
        int digit = 1;

        while (num > 0) {
            digit *= 10;
            num /= 10;
        }

        return digit;
    }
}
