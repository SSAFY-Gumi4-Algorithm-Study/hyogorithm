import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> work = new HashMap<>();
        int latestDeadline = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int duration = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());

            work.put(deadline, work.getOrDefault(deadline, 0) + duration);

            latestDeadline = Math.max(latestDeadline, deadline);
        }

        List<Integer> deadlines = new ArrayList<>(work.keySet());
        deadlines.sort(Collections.reverseOrder());

        int availableTime = latestDeadline;

        for (int deadline : deadlines) {
            if (availableTime > deadline) availableTime = deadline;
            availableTime -= work.get(deadline);
        }

        System.out.println(availableTime);
    }
}
