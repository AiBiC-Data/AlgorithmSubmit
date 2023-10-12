import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static StringTokenizer st;
	static int[][] map, dp;
	static int comp=0;
	static int ans = Integer.MAX_VALUE;
	static final int INF = Integer.MAX_VALUE >> 4;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		comp = (1 << N) - 1;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[N][comp + 1];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}

		int visit = 1;
		ans = tsp(0, visit);
		System.out.println(ans);
		

	}

	private static int tsp(int i, int v) {
		if (v == comp) {
			if (map[i][0] == 0)
				return INF;
			return map[i][0];
		}

		if (dp[i][v] != -1)
			return dp[i][v];
		
		dp[i][v] = INF;

		for (int j = 0; j < N; j++) {
			if (map[i][j] == 0)
				continue;
			if ((v & (1 << j)) !=0)
				continue;
			dp[i][v] = Math.min(dp[i][v], tsp(j, (v | (1 << j))) + map[i][j]);
		}

		return dp[i][v];
	}

}
