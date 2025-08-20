import java.io.*;
import java.util.*;

public class Main {
	static int n, min;
	static int[][] s;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		s = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());	
			}			
		}
		
		min = Integer.MAX_VALUE;
		bt(new ArrayList<>(), 0);
		System.out.println(min);
	}

	static void bt(List<Integer> team1, int start) {
		if (team1.size() == n/2) {
			List<Integer> team2 = new ArrayList<>();
			boolean[] isTeam1 = new boolean[n];
			for (int t : team1) {
				isTeam1[t] = true;
			}
			
			for(int i = 0; i < n; i++) {
				if(!isTeam1[i]) team2.add(i);
			}
			
			int score1 = getScore(team1);
			int score2 = getScore(team2);
			min = Math.min(min, Math.abs(score1 - score2));
			
			return;
		}
		
		for (int i = start; i < n; i++) {
			team1.add(i);
			bt(team1, i + 1);
			team1.remove(team1.size() - 1);
		}
		
	}

	static int getScore(List<Integer> team) {
		int score = 0;
		for(int i = 0; i < team.size(); i++) {
			for (int j = 0; j < team.size(); j++) {
				if (i == j) continue;
				score += s[team.get(i)][team.get(j)];
			}
		}
		return score;
	}
}
